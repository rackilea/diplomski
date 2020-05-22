final StackTraceElement[] stack = Thread.currentThread().getStackTrace();

if (! stack[stack.length-1].getClassName().equals(YourClass.class.getName()))
{
  // abort
}