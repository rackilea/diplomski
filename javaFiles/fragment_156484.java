@RunWith(MyRunner.class)
public class AbstractTestCase
{
    private static boolean setupDone = false;
    static
    {
        if(!setupDone)
        {
            setupDone = true;
            //Do whatever setup needs to be done
        }
    }
...