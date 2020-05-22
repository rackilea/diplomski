class RockModule extends AbstractModule {
  public void configure() {}

  @Provides
  @Named("UUID")
  public String getUuid() {
    return UUID.getRandomId().toString();
  }
}