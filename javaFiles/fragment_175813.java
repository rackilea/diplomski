class SomeClass
{
    public SomeClass(DangerousSelfReference dangerousSelfReference)
    {
        System.out.println("State: ");
        System.out.println("   a: "+dangerousSelfReference.getA());
        System.out.println("   b: "+dangerousSelfReference.getB());
        System.out.println("   c: "+dangerousSelfReference.getC());
        System.out.println("   d: "+dangerousSelfReference.getD());
        System.out.println(" ref: "+dangerousSelfReference.getRef());
    }
}

public class DangerousSelfReference
{
    public static void main(String[] args)
    {
        DangerousSelfReference d = new DangerousSelfReference();
    }

    private String a;
    private String b = "b";
    private final SomeClass ref = new SomeClass(this);
    private final String c = "c";
    private String d = "d";

    DangerousSelfReference()
    {
        a = "a";
    }

    String getA()
    {
        return a;
    }
    String getB()
    {
        return b;
    }
    String getC()
    {
        return c;
    }
    String getD()
    {
        return d;
    }
    SomeClass getRef()
    {
        return ref;
    }
}