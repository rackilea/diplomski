public static void methodB()
{
    int count = 0;

    StackTraceElement[] elements = Thread.currentThread().getStackTrace();
    for (StackTraceElement element : elements)
    {
        count += element.getLineNumber();
    }

    System.out.println(count);
}