@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/something.feature",
        format = "com.blah.PrintingFormatter",
        glue = "com.blah.steps")
public class CucumberTest {

}