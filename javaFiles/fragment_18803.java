public abstract class BasePage extends WebPage {

  @SpringBean
  private I18NResourceLoader i18NResourceLoader;

  public BasePage(){
    addI18NResourceLoader();

      ...

  }

  private void addI18NResourceLoader() {
    final List<IStringResourceLoader> resourceLoaders = Application.get().getResourceSettings().getStringResourceLoaders();
    final boolean existsResourceLoader = resourceLoaders.stream()
            .filter(p -> p instanceof I18NResourceLoader)
            .collect(Collectors.counting()) > 0L;
    if (!existsResourceLoader) {
        resourceLoaders.add(i18NResourceLoader);
    }
  }

  ...

}