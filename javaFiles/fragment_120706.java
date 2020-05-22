public abstract class AnyCompositeData implements CompositeDataView {
  private final String type;

  public AnyCompositeData(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public static AnyCompositeData from(CompositeData cd) {
    switch ((String) cd.get("type")) {
      case "Foo":
        return new Foo((String) cd.get("foo"));
      default:
        throw new IllegalArgumentException("Don't know how to reconstruct: " + cd.get("type"));
    }
  }

  public static class Foo extends AnyCompositeData {
    private final String foo;

    Foo(String foo) {
      super("Foo");
      this.foo = foo;
    }

    public String getFoo() {
      return foo;
    }

    @Override
    public CompositeData toCompositeData(CompositeType ct) {
      try {
        String[] items = {"type", "foo"};
        OpenType<?>[] itemTypes = {SimpleType.STRING, SimpleType.STRING};
        Object[] itemValues = {"Foo", foo};
        CompositeType compositeType = new CompositeType("Foo", "Foo", items, items, itemTypes);
        return new CompositeDataSupport(compositeType, items, itemValues);
      } catch (OpenDataException e) {
        throw new RuntimeException(e);
      }
    }
  }

  @MXBean
  public interface Baz {
    AnyCompositeData f();
  }

  static class BazImpl implements Baz {
    @Override
    public AnyCompositeData f() {
      return new Foo("whatever");
    }
  }

  public static void main(String[] args) throws Exception {
    MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
    ObjectName objectName = new ObjectName("test:baz=baz");
    mbs.registerMBean(new BazImpl(), objectName);
    Baz bazProxy = JMX.newMXBeanProxy(mbs, objectName, Baz.class);
    AnyCompositeData result = bazProxy.f();
    assert result instanceof Foo;
    assert ((Foo) result).getFoo().equals("whatever");
  }
}