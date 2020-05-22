public class TestA
{

    public TestA()
    {
        String as[];
        int j = (as = getTheStrings()).length;
        for(int i = 0; i < j; i++)
        {
            String string = as[i];
            System.out.println(string);
        }

    }

    public String[] getTheStrings()
    {
        System.out.println("get the strings");
        return theStrings;
    }

    public static void main(String args[])
    {
        new TestA();
    }

    public String theStrings[] = {
        "one", "two", "three"
    };
}