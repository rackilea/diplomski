public class PropertiesObjectFactory implements Serializable, ObjectFactory {

    /**
     * File property name.
     */
    public static final String FILE_PROPERTY_NAME = "org.glassfish.resources.custom.factory.PropertiesFactory.fileName";

    /**
     * Implemented method from object factory interface.
     *
     * @param obj object
     * @param name name
     * @param nameCtx context name
     * @param environment environment
     * @return file properties
     * @throws Exception if error occurs
     */
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment)
            throws Exception {
        Reference ref = (Reference) obj;
        Enumeration<RefAddr> refAddrs = ref.getAll();

        String fileName = null;
        Properties fileProperties = new Properties();
        Properties properties = new Properties();

        while (refAddrs.hasMoreElements()) {
            RefAddr addr = refAddrs.nextElement();
            String type = addr.getType();
            String value = (String) addr.getContent();

            if (type.equalsIgnoreCase(FILE_PROPERTY_NAME)) {
                fileName = value;
            } else {
                properties.put(type, value);
            }
        }

        if (fileName != null) {
            File file = new File(fileName);
            if (!file.isAbsolute()) {
                file = new File(System.getProperty("com.sun.aas.installRoot") + File.separator + fileName);
            }
            try {
                if (file.exists()) {
                    try {
                        FileInputStream fis = new FileInputStream(file);
                        if (fileName.toUpperCase().endsWith("XML")) {
                            fileProperties.loadFromXML(fis);
                        } else {
                            fileProperties.load(fis);
                        }
                    } catch (IOException ioe) {
                        throw new IOException("IO Exception during properties load : " + file.getAbsolutePath());
                    }
                } else {
                    throw new FileNotFoundException("File not found : " + file.getAbsolutePath());
                }
            } catch (FileNotFoundException fnfe) {
                throw new FileNotFoundException("File not found : " + file.getAbsolutePath());
            }
        }
        fileProperties.putAll(properties);
        return fileProperties;
    }
}