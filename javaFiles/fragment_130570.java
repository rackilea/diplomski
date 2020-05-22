package runner;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
//import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
//import org.jbehave.core.steps.ScanningStepsFactory;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import stepdefs.StepDefs;
//import stepdefs.BarStep;
//import stepdefs.FooStep;

@RunWith(JUnitReportingRunner.class)
public class JBehaveTestsRunner extends JUnitStories {

    private CrossReference xref = new CrossReference();

    public JBehaveTestsRunner() {
        configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
                .doIgnoreFailureInView(true).doVerboseFailures(true);// .useThreads(1);
    }

    @Override
    public Configuration configuration() {
        Properties viewResources = new Properties();
        viewResources.put("decorateNonHtml", "true");
        return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withFormats(Format.HTML, Format.CONSOLE, Format.STATS).withViewResources(viewResources)
                        .withFailureTrace(true).withFailureTraceCompression(false).withCrossReference(xref));
    }

    /*@Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), new FooStep(), new BarStep(), new StepDefs())
                .createCandidateSteps();
    }*/

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new StepDefs());
        // return new ScanningStepsFactory(configuration(), "stepdefinitions");
    }

    @Override
    public List<String> storyPaths() {
        StoryFinder finder = new StoryFinder();
        return finder.findPaths(CodeLocations.codeLocationFromClass(getClass()), Arrays.asList("**/Sample.story"),
                null);
    }
}