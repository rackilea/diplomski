@RunWith(Cucumber.class)

@CucumberOptions(  monochrome = true,
                     features = "src/dummy/pkg/features/",
                       format = { "pretty","html: cucumber-html-reports",
                                  "json: cucumber-html-reports/cucumber.json" },
                         glue = "your_step_definition_location_package" )

public class YourClass {
  //Run this from Maven or as JUnit
}