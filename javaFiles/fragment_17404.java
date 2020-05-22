public static boolean isCalledInStaticInitializer()
{
    for (StackTraceElement ste : Thread.currentThread().getStackTrace())
    {
        if("<clinit>".equals(ste.getMethodName()))
        {
            return true;
        }
    }
    return false;
}