public static void runSuite(String jarFilePath, Suite s)
        throws MalformedURLException, ClassNotFoundException {
    //Don't confuse : XmlSuite here, is the standard testNg class. our bean class is Suite
    XmlSuite suite = new XmlSuite();
    suite.setName(s.getName());

    for (Test t : s.getTestCases()) {
        XmlTest test = new XmlTest(suite);
        test.setName(t.getName());
        List<XmlClass> classes = new ArrayList<XmlClass>();
        for (TestClass tc : t.getClasses()) {
            Class cls =  loadClass(jarFilePath, tc.getName());
            if (cls != null) {
                XmlClass xClass = new XmlClass(cls, false);
                classes.add(xClass);
                test.setXmlClasses(classes);
            }
        }
    }
    List<XmlSuite> suites = new ArrayList<XmlSuite>();

    suites.add(suite);
    TestNG tng = new TestNG();

    tng.setXmlSuites(suites);
    tng.run();
}

public Class loadClass(String jarFilePath, String className) throws MalformedURLException,
        ClassNotFoundException {
File jarFile  = new File(jarFilePath);
    if (jarFile.isFile()) {
        URL url = jarFile.toURL();
        URL[] urls = new URL[] { url };
        ClassLoader cl = new URLClassLoader(urls);
        return cl.loadClass(className);
    } else {
        return null;
    }
}