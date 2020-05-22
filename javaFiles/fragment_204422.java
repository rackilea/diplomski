public class EachStepScreenshoter extends LifecycleListener {

    @Override
    public void fire(StepStartedEvent event) {
        takeScreenshot();
    }

    @Override
    public void fire(StepFinishedEvent event) {
        takeScreenshot();
    }

    @Attachment(value="A screenshot")
    private byte[] takeScreenshot() {
        //Return screenshot content
    }
}