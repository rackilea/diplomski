import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import java.io.File;

public class JMeterFromCode {

    public static void main(String[] argv) throws Exception {


        //Define JVM Proxy Settings
        System.setProperty("http.proxyHost", "localhost");
        System.setProperty("http.proxyPort", "8888");
        System.setProperty("https.proxyHost", "localhost");
        System.setProperty("https.proxyPort", "8888");
        System.setProperty("http.nonProxyHosts", "");

        // JMeter Engine
        StandardJMeterEngine jmeter = new StandardJMeterEngine();

        // Initialize Properties, logging, locale, etc.
        JMeterUtils.loadJMeterProperties("/tmp/jmeter/bin/jmeter.properties");
        JMeterUtils.setJMeterHome("/tmp/jmeter");
        JMeterUtils.initLocale();


        // Initialize JMeter SaveService
        SaveService.loadProperties();

        // Load existing .jmx Test Plan
        HashTree testPlanTree = SaveService.loadTree(new File("/tmp/jmeter/bin/test.jmx"));

        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
        if (summariserName.length() > 0) {
            summer = new Summariser(summariserName);
        }

        ResultCollector logger = new ResultCollector(summer);
        logger.setFilename("/tmp/jmeter/test.jtl");
        testPlanTree.add(testPlanTree.getArray()[0], logger);


        // Run JMeter Test
        jmeter.configure(testPlanTree);
        jmeter.run();
    }
}