public class Called {
static String count="one"; //observe this static string usage
static void call1()
{
    if(count.equals("one"))
    {
        System.out.println("Same");
        count="somestring"; //call1() if condition will fail with this string not equal to "one"

    }
    else
    {
    System.out.println("Not Same");
    }
}
static void call2()
{

        System.out.println("Same");
}

}