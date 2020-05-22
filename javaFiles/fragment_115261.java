public void readPropertyByType(String type)
    {
        InputStream input = null;
        try
        {
            Properties prop = new Properties();

            // if your type is Type4, the typeKey will be Type4. for compare data
            String typeKey = type + ".";

            String filename = "config.properties";
            input = new FileInputStream(filename);
            prop.load(input);

            String typeInformation = "";
            Enumeration< ? > e = prop.propertyNames();
            while (e.hasMoreElements())
            {
                String key = (String)e.nextElement();
                if (key.indexOf(typeKey) > 0)
                {
                    typeInformation = typeInformation + prop.getProperty(key);
                }
            }
            System.out.println("The data of type " + type + "is :" + typeInformation);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if (input != null)
            {
                try
                {
                    input.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }