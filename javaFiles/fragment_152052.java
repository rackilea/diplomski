public class CucumberStepsFeature1 {

    private final PropsConfig propsConfig;

    public CucumberStepsFeature1() {
        this.propsConfig = SpringApplicationContextContainer.getApplicationContext().getBean(PropsConfig.class);
    }

    @Given("...")
    public void given() {
        // passes below
        assertNotNull(this.propsConfig);
    }