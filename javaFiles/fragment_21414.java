private final static CopyOnWriteArraySet<Driver> loadedDrivers = new CopyOnWriteArraySet<>();

private static Driver isLoaded(String drivername, String... classpath) throws ClassNotFoundException
{
    Driver tdriver = loadedDrivers.stream().filter(d -> d.getClass().getName().equals(drivername)).findFirst().orElseGet(() ->
    {
        try
        {
            Driver itdriver = (Driver) Class.forName(drivername, true, addToClasspath(classpath)).newInstance();
            loadedDrivers.add(itdriver);
            return itdriver;
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException e)
        {
            return null;
        }
    });
    if (tdriver == null)
        throw new java.lang.ClassNotFoundException(drivername + " not found.");
    return tdriver;
}