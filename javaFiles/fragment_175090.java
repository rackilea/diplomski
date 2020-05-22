public class PropertyLoaderJobExecutionListener extends StepExecutionListenerSupport {
  Properties countryProperties;

  public void setCountryProperties(Properties pfb) {
    this.countryProperties = pfb;
  }

  @Override
  public void beforeStep(StepExecution stepExecution) {
    super.beforeStep(stepExecution);
    // Store property file content in jobExecutionContext with name "batchProperties"
    stepExecution.getJobExecution().getExecutionContext().put("batchProperties", countryProperties);
  }
}