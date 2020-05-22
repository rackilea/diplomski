package MyRunner;   
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/features"
 ,glue={"src/test/stepDefinition"}
 ,monochrome = false
 )

public class testRunner {

}