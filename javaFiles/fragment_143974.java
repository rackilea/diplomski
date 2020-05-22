import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith (Parameterized.class)
public class BusinessClassTest{
    @Parameters(name="{0}:{1}")
    public static Collection<Object[]> getTestPaths() {
        Collection<Object[]> allTests = new ArrayList<>();

         File file = new File("/fixtures/");
          String[] dirs = file.list((current, name) -> 
                            new File(current, name).isDirectory());

          for (String testNumber : dirs) {
            String inputPath = "/fixtures/" + dirs + "/input";
            String expectedPath = "/fixtures/" + dirs + "/expected";
            allTests.add(asConstructorArguments(inputPath, expectedPath));
          }

        return allTests;
    }

    private static Object[] asConstructorArguments(String inputPath, String expectedPath) {
        return new Object[]{inputPath, expectedPath};
    }

    private final String inputData;
    private final String expectedData;
    private final Fixture fakedFixture;


    public BusinessClassTest(String input, final String expected) {
        this.inputData = input;
        this.expectedData = expected;
        fakedFixture = new Fixture() {          
            @Override
            public String process(String path) {
                return expected;
            }
        };
    }

    @Test
    public void validateFixture() {
        //feed it to a fixture
        String actualData = fakedFixture.process(inputData);
        Assert.assertEquals(expectedData, actualData);
    }

    //Interface to emulate your API
    public interface Fixture {
        String process(String path);
    }
}