/**
     * <p>
     * Looks inside a jar file and looks for implementing classes of the provided interface.
     * </p>
     *
     * @param file
     * The Jar-File containing the classes to scan for implementation of the given interface
     * @param iface
     * The interface classes have to implement
     * @param loader
     * The class loader the implementing classes got loaded with
     * @return A {@link List} of implementing classes for the provided interface
     * inside jar files of the <em>ClassFinder</em>s class path
     *
     * @throws Exception If during processing of the Jar-file an error occurred
     */
    public List<Class<?>> findImplementingClassesInJarFile(File file, Class<?> iface, ClassLoader loader) throws Exception
    {
        List<Class<?>> implementingClasses = new ArrayList<Class<?>>();
        // scan the jar file for all included classes
        for (String classFile : scanJarFileForClasses(file))
        {
            Class<?> clazz;
            try
            {
                // now try to load the class
                if (loader == null)
                    clazz = Class.forName(classFile);
                else
                    clazz = Class.forName(classFile, true, loader);

                // and check if the class implements the provided interface
                if (iface.isAssignableFrom(clazz) && !clazz.equals(iface))
                    implementingClasses.add(clazz);
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        return implementingClasses;
    }