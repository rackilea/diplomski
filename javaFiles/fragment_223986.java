import java.beans.*;

public class Bean {
  public Object getSPSExchangedDocument() {
    return null;
  }

  public static void main(String[] args) throws IntrospectionException {
    BeanInfo info = Introspector.getBeanInfo(Bean.class);
    for (PropertyDescriptor prop : info.getPropertyDescriptors()) {
      System.out.println(prop.getName());
    }
  }
}