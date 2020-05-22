try
{
    // Get all the files in mod folder
    File[] mods = new File("mod").listFiles();

    for (int i=0; i<mods.length; i++)
    {
        // Skip if the file is not a jar
        if (!mods[i].getName().endsWith(".jar"))
            continue;

        // Create a JarFile
        JarFile jarFile = new JarFile(mods[i]);

        // Get the entries
        Enumeration e = jarFile.entries();

        // Create a URL for the jar
        URL[] urls = { new URL("jar:file:" + mods[i].getAbsolutePath() +"!/") };
        cl = URLClassLoader.newInstance(urls);

        while (e.hasMoreElements())
        {
            JarEntry je = (JarEntry) e.nextElement();

            // Skip directories
            if(je.isDirectory() || !je.getName().endsWith(".class"))
            {
                continue;
            }

            // -6 because of .class
            String className = je.getName().substring(0,je.getName().length()-6);
            className = className.replace('/', '.');

            // Load the class
            Class c = cl.loadClass(className);
        }
    }
}
catch (Exception e)
{
    e.printStackTrace();
}