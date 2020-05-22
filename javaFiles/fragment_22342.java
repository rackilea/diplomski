public class IsEmptyCollection implements Matcher<Collection<?>>
{
    public static Matcher<Collection<?>> empty()
    {
        return new IsEmptyCollection();
    }
}