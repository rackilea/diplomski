@RunWith(Cucumber.class)

@CucumberOptions(  monochrome = true,
                         tags = "@tags",
                     features = "src/test/resources/features/",
                       format = { "pretty","html: cucumber-html-reports",
                                  "json: cucumber-html-reports/cucumber.json" },
                        dryRun = false,
                         glue = "fr.tlasnier.cucumber" )

public class RunCucumber_Test {
  //Run this
}