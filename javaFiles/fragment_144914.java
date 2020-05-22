enum TrickyEnum
{
    TrickyEnum1, TrickyEnum2;

    static int count = 123; // Added an initial value

    TrickyEnum()
    {
        incrementCount();
    }

    private static void incrementCount()
    {
        count++;
        System.out.println("Count: " + count);
    }

    public static void showCount()
    {
        System.out.println("Count: " + count);
    }
}

public static void main (String[] args) throws java.lang.Exception
{
    TrickyEnum te = TrickyEnum.TrickyEnum1;
    TrickyEnum.showCount();
}