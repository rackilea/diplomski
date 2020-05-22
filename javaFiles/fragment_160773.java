StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
if (stackTraceElements.length < 3)
{
    // do something when last method to call is not available
    // probably you'll want to return something
}
String callerMethod = stackTraceElements[2].getMethodName();
if (callerMethod.equals("m1"))
{
    // something
} else
{
    // something else
}