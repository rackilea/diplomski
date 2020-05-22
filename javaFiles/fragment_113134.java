class NarrowingReferenceConversion
{
    public static void main(String args[])
    {

        S s = new S2();
        T t = (T) s; // this will work, since S2 implements T

    }
}

interface T
{
    public void print();
}

class S
{
    public void print(){
        System.out.println("S.print()");
    }
}

class S2 extends S implements T
{
}