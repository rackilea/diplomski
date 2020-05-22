Properties mavenProps = new Properties();
 InputStream in = TestClass.class.getResourceAsStream("/maven.properties");
 mavenProps.load(in);

 String buildDir = mavenProps.getProperty("project.build.directory");
 String myVar = mavenProps.getProperty("MY_VARIABLE");