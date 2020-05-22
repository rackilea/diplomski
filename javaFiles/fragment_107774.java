public class ITestContextLoader extends GenericXmlWebContextLoader {

    @Override
    protected void loadBeanDefinitions(...) { 

        // Initial Context configuration

        Resource jettyXml = Resourse.newSystemResource("jetty-env.xml");
        InputStream resourceStream = jettyXml.getInputStream();
        XmlConfiguration xmlConfig = new XmlConfiguration(resourceStream);

        xmlConfig.configure(); // for some reason it's not only returns 
                               // instance of configured context, but also 
                               // populates InitialContext with JNDI resources


        // Bean definitions loading

        ... 
    }
}