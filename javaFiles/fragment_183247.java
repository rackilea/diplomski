@CucumberOptions (
        features = {"src/test/java/CucumberFramework/featureFiles/"},
        glue = {"CucumberFramework.steps"}, // < I changed this
        monochrome = true,
        tags = {},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "com.cucumber.listener.ExtentCucumberFormatter:target/report.html"}
        )