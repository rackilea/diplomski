public class JaxbWrapperFactory {
    Map<String, JaxbWrapper> pool = new ConcurrentHashMap(); // recommend Guava's Cache

    public JaxbWrapper create(String ClassName, String packageName) throws ClassNotFoundException, InstantiationException { }

    public Object loadXML(String xmlFile, String fileName) throws Exception {
     /// use create from above
    }

}