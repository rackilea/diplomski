public class Main
{

    public static enum State
    {

        A, D, H
    };

    public static void main(String[] args)
    {
        Test[] tests = new Test[]
        {
            new Test(new State[]
            {
                State.A, State.H, State.A, State.H
            }),
            new Test(new State[]
            {
                State.A, State.H, State.A, State.D
            }),
            new Test(new State[]
            {
                State.H, State.D, State.A, State.A
            })
        };
        Test testMerged = Test.merge(tests);
        System.out.println("The input arrays are" + testMerged);
    }
}