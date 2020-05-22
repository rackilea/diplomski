import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestRunner {
    public static void main(String[] args) {

        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Sample_Suite");
        Map<String, String> fieldValues = new ParamContainer().getValues();
        xmlSuite.setParameters(fieldValues);
        XmlTest xmlTest = new XmlTest(xmlSuite);
        xmlTest.setName("Sample_test");
        xmlTest.setXmlClasses(Collections.singletonList(new XmlClass(HelloWorld.class)));
        TestNG tng = new TestNG();
        tng.setXmlSuites(Collections.singletonList(xmlSuite));
        tng.run();
    }

    /**
     * This is a test class.
     */
    public static class HelloWorld {
        @Test
        @Parameters("name")
        public void hi(String name) {
            Assert.assertNotNull(name);
            Reporter.log("Name is:" + name, true);
        }
    }

    /**
     * Simulates a class that will contain all the key/value pairs that are to be used as
     * <code><parameters></code> for the suite.
     */
    public static class ParamContainer {
        private Map<String, String> values = new HashMap<>();

        ParamContainer() {
            values.put("name", "Jack-Daniel");
        }

        Map<String, String> getValues() {
            return values;
        }
    }

}