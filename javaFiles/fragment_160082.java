import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.Collections;

public class Mainone {
    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();

        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.getParameters().put("sUsername", "admin");
        xmlSuite.getParameters().put("sPassword", "admin");
        xmlSuite.getParameters().put("sUrl", "http://localhost");
        xmlSuite.setName("Sample_Suite");
        XmlTest xmlTest = new XmlTest(xmlSuite);
        xmlTest.setName("Sample_Test");
        xmlTest.setClasses(Collections.singletonList(new XmlClass(RMS_Login.class)));
        testng.addListener((ITestNGListener) tla);
        testng.setXmlSuites(Collections.singletonList(xmlSuite));
        testng.run();
    }

    public static class RMS_Login {

        @Parameters({"sUsername", "sPassword", "sUrl"})
        @Test
        public void uatRMSLoginTest(String sUsername, String sPassword, String sUrl) {
            //Since I don't know what this method is supposed to do,
            //Just printing them out.
            System.err.println("UserName " + sUsername);
            System.err.println("Password " + sPassword);
            System.err.println("URL " + sUrl);
        }
    }
}