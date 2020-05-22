testproject
  xsdfolder
    schema.xsd
  javaclassfolder
    SomeClass.java

public static class SomeClass {

    public static URL getLocalXsd() throws MalformedURLException {
      URL baseUrl = SomeClass.class.getResource(SomeClass.class.getSimpleName() + ".class");
      return new URL(baseUrl, "../xsdfolder/schema.xsd");
    }
}