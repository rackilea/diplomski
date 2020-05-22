public class Test
{

    static Main.State[] in;

    public static Test merge(Test[] tests)
    {
        int size = calculateSize( tests );
        Main.State[] state = new Main.State[size];
        int i = 0;
        for ( Test test : tests )
        {
            for ( Main.State s : test.in )
                state[i++] = s;
        }
        return new Test( state );
    }

    private static int calculateSize(Test[] tests)
    {
        int result = 0;
        for ( Test test : tests )
        {
            for ( Main.State s : test.in )
                ++result;
        }
        return result;
    }

    Test(Main.State[] in)
    {
        this.in = in;
    }

    @Override
    public String toString()
    {
        String result =java.util.Arrays.toString(in);
        result = result.replaceAll(",", "");
        result = result.replaceAll(" ","");
        return result;
    }
}