class Application extends GrailsAutoConfiguration {

  @Override
  protected boolean limitScanningToApplication() {
    false
  }

  @Override
  Collection<String> packageNames() {
    super.packageNames() + 'your.domainclass.package'
  }

}