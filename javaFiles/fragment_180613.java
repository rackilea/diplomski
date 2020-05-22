public class OwnableObject
{
    protected Object owner;

    public OwnableObject(Object anOwner) { owner = anOwner; }
    public Object getOwner() { return owner; }
    public void setOwner(Object anOwner) { owner = anOwner; }
}

public class MyString extends OwnableObject
{
    protected String str = null;

    public MyString(Object anOwner) { super(anOwner); }
    public String toString() { return str; }
    public void set(String aString) { str = aString; }
}

public class FieldWrapper<E> extends OwnableObject
{
    protected E value = null;

    public FieldWrapper(Object anOwner) { super(anOwner); }
    public E getValue() { return value; }
    public void setValue(E aValue) { value = aValue; }
}

public class Demo
{
    protected MyString s = new MyString(this);
    protected FieldWrapper<Integer> i = new FieldWrapper<Integer>(this);

    public void setS(String aString) { s.set(aString); }
    public void setI(int anInt) { i.setValue(anInt); }
    public String toString() { return "Demo(" + s + "," + i.getValue() + ")"; }

    public static void main(String[] args)
    {
        Demo d1 = new Demo();
        Demo d2 = new Demo();

        MyString f1 = d1.s;
        FieldWrapper<Integer> f2 = d1.i;
        OwnableObject f3 = d2.s;
        OwnableObject f4 = d2.i;

        d1.setS("one");
        d2.setS("two");
        d1.setI(1000);
        d2.setI(2000);

        p("f1 = %s, owner = %s", f1, f1.getOwner());
        p("f2 = %d, owner = %s", f2.getValue(), f2.getOwner());
        p("f3 = %s, owner = %s", f3, f3.getOwner());
        p("f4 = %s, owner = %s", f4, f4.getOwner());
    }

    static void p(String fmt, Object... args)
    {
        System.out.format(fmt, args);
        System.out.println();
    }
}