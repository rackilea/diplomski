try
{
    Class<?> s = this.getClass();
    while ( !"java.lang.Object".equals(s.getSuperclass().getName())  )
    {
        s = s.getSuperclass();
    }
    Method m = s.getMethod(Thread.currentThread().getStackTrace()[1].getMethodName(), (Class<?>[])null);
    if ( m != null )
    {
        m.invoke(s.newInstance()); // This is the actual call to the 'super' method.
    }
}
catch ( Exception e )
{
    e.printStackTrace();
}