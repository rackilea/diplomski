public static void main (String [] args)
{
    Properties databasesProperties = new Properties ();
    databasesProperties.load ("databases.properties");

    for (String arg: args)
    {
        String url = databasesProperties.get (arg + ".url");
        String user = databasesProperties.get (arg + ".user");
        String password= databasesProperties.get (arg + ".password");
        String table = databasesProperties.get (arg + ".table");

        String columnPrefix = arg + ".column."
        Map <String, String> columns = new HashMap <String, String> ();
        for (String key: databasesProperties.stringPropertyNames ())
        {
            if (key.startsWith (columnPrefix))
                columns.put (
                    key.substring (columnPrefix.length ()), 
                    databasesProperties.get (key));
        }

        doInsert (url, user, password, table, columns);
    }
}