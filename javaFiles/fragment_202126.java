public class RunnerTest {
    private static String[] defaultOptions = {
            "--glue", "ru.ab.cd.stepDefs",
            "--glue", "ru.abcd.tag.stepdefs",
            "--tags", "@TEST2",
            "src/test/resources/features/"
    };

    public static void main(String[] args) throws Throwable {
        Stream<String> cucumberOptions = Stream.concat(Stream.of(defaultOptions), Stream.of(args));
        cucumber.api.cli.Main.main(cucumberOptions.toArray(String[]::new));
    }
}