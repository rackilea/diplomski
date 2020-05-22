import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
dryRun = false,
strict = true,
plugin = {"pretty"},
features = {"path/to/features"},
glue = {"package.of.steps"},
tags = {"@TagsToRun"})

public class MyCucumberTestRunnner {
    public MyCucumberTestRunnner() {
    }
}