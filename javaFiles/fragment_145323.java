OperatingSystemMXBean operatingSystemMXBean = 
    ManagementFactory.getOperatingSystemMXBean();

for (Method method: operatingSystemMXBean.getClass ().getMethods ()) 
{
    method.setAccessible (true);
    String methodName = method.getName ();
    if (methodName.startsWith ("get")
        && Modifier.isPublic (method.getModifiers ())
        && OperatingSystemMXBean.class.isAssignableFrom (
            method.getDeclaringClass ())) {
        try
        {
            System.out.println (
                methodName.substring (3) + ": " + 
                method.invoke (operatingSystemMXBean));
        }
        catch (Throwable ex)
        {
            // Ignore
        }
    }
}