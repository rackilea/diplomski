class Example
{
    public static void usePrimitiveInt(int i) { }
    public static void useIntegerClass(Integer i) { }

    public static void main(String [] args)
    {
        int i = 5;
        Integer iObj = 10;
        Example.usePrimitiveInt(i); // use primitive
        Example.useIntegerClass(i); // autobox int to Integer
        Example.usePrimitiveInt(iObj); // unbox iObj into primitive
    }
}