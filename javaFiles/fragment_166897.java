import java.util.Hashtable;


class MyClass
{
    private final Foo foo;
    private final Bar bar;
    private final Hashtable<String, String> params;

    public MyClass(final Hashtable<String, String> params)
    {
        this(params, GlobalClass.GLOBALVAR);
    }

    // added constructor
    public MyClass(final Hashtable<String, String> params, 
                   final FooBar fooBar)
    {
        this.foo    = fooBar.getFoo();
        this.bar    = fooBar.getBar();
        this.params = params;
    }
}

class MySubClass
    extends MyClass
{
    public MySubClass(final Hashtable<String, String> params)
    {
        super(params);
    }

    // added constructor
    public MySubClass(final Hashtable<String, String> params, 
                      final FooBar fooBar)
    {
        super(params, fooBar);
    }
}

// unchanged
class GlobalClass
{
    public static Car GLOBALVAR;
}

// added interface
interface FooBar
{
    Foo getFoo();
    Bar getBar();
}

class Car
    // added implements
    implements FooBar
{
    private Foo foo = new Foo();
    private Bar bar = new Bar();

    public Object get(final String name)
    {
        if(name.equals("foo"))
        {
            return (foo);
        }

        if(name.equals("bar"))
        {
            return (bar);
        }

        throw new Error();
    }

    // added method
    public Foo getFoo()
    {
        return ((Foo)get("foo"));
    }

    // added method
    public Bar getBar()
    {
        return ((Bar)get("bar"));
    }
}

// unchanged
class Foo
{
}

// unchanged
class Bar
{
}