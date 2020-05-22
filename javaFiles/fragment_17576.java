public class Database
{
    private static final class InstanceHolder
    {
        static final Database INSTANCE = new Database();
    }

    private static final class DynamicURLClassLoader
        extends URLClassLoader
    {

        public DynamicURLClassLoader(URL[] urls, ClassLoader parent)
        {
            super(urls, parent);
        }


        @Override
        protected void addURL(URL url)
        {
            super.addURL(url);
        }

    }

    // skipped

    private DynamicURLClassLoader childClassloader;

    private Database()
    {
        childClassloader = new DynamicURLClassLoader(new URL[]{}, this.getClass().getClassLoader());
    }

    public static Database getInstance()
    {
        return InstanceHolder.INSTANCE;
    }

    private synchronized Connection getConnection()
        throws Exception
    {
        // load JDBC drivers from jar file
        File driverFile = new File(pathToJar);
        childClassloader.addURL(driverFile.toURI().toURL());

        java.util.Properties info = new java.util.Properties();

        if (dbUser != null)
        {
            info.put("user", dbUser);
        }
        if (dbPassword != null)
        {
            info.put("password", dbPassword);
        }

        if (dbURL == null)
        {
            throw new SQLException("The url cannot be null", "08001");
        }
        Class< ? > clazz = Class.forName(className, true, childClassloader);
        if (clazz != null)
        {
            Driver driver = (Driver)clazz.newInstance();
            // Open a connection. If no exception is thrown, the settings work
            Connection con = driver.connect(dbURL, info);
            if (con != null)
                // Success!
                return (con);
        }
        throw new SQLException("The chosen driver is not suitable for " + dbURL, "08001");
    }
}