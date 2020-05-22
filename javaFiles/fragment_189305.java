// Note: class is NOT public -- its default constructor won't be either
final class Test
{
    public static void main(final String... args)
        throws NoSuchMethodException
    {
        // throws NoSuchMethodException
        Test.class.getConstructor();
    }
}