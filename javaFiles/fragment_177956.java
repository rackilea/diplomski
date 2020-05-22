private static int result = 0;
private static synchronized int staticMethod(Object... args)
{
      result = args.length;
      //Do Something
      return result;
}