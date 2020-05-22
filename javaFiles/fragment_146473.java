public class Test
{


    static class Type2
    {
    }

    static class Type1
    {

    }

    static class TestT extends Type1
    {

    }


    public static void main(String[] args)
    {
        List<TestT> l = new ArrayList<TestT>();
        Type2 type2 = method(l);
    }

    public static <T extends Type1> Type2 method(Collection<T> my_collection)
    {
        return new Type2();
    }

}