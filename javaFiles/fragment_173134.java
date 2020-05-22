import java.util.Map;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlTest;

public class CustomListen3 extends TestListenerAdapter {
    /**
     * Invoked after test class in initialized and before all the getters and
     * setters are called.
     */
    @Override
    public void onStart(ITestContext context) {
        // Get the current test
        XmlTest currentTest = context.getCurrentXmlTest();
        // Get all the parameters Global and local
        Map<String, String> parameters = currentTest.getAllParameters();
        for (String key : parameters.keySet()) {
            String parameterValue = parameters.get(key);
            // If parameter value starts with $, replace with the global parameter value
            if (parameterValue.startsWith("$")) {
                String newValue = currentTest.getParameter(parameterValue.substring(1));
                Assert.assertNotNull(newValue, "Global parameter value, " + parameterValue.substring(1));
                parameters.put(key, newValue);
            }
        }
        // Update the new parameters
        currentTest.setParameters(parameters);
        super.onStart(context);
    }
}