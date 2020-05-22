File f = new File("/Windows/F/Programming/Projects/NetBeans/TestApplications/database prop.properties");
        System.out.println(f.exists());
        try
        {
            FileInputStream stream = new FileInputStream(f);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }