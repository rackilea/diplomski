// Code from com.sun.org.apache.xml.internal.dtm.ObjectFactory
static String lookUpFactoryClassName(String factoryId,
                                     String propertiesFilename,
                                     String fallbackClassName) {
  SecuritySupport ss = SecuritySupport.getInstance();

  try {
    String systemProp = ss.getSystemProperty(factoryId);
    if (systemProp != null) { 

      // Return early from the method
      return systemProp;
    }
  } catch (SecurityException se) {
  }

  // [...] "Heavy" operations later