@org.springframework.stereotype.Component
public class I18NResourceLoader implements IStringResourceLoader {

  @Autowired
  private I18NCache i18nCache;

  @Override
  public String loadStringResource(final Class<?> clazz, final String key, final Locale locale, final String style, final String variation) {
    return loadTranslation(key, locale);
  }

  @Override
  public String loadStringResource(final Component component, final String key, final Locale locale, final String style, final String variation) {
    return loadTranslation(key, locale);
  }

  private String loadTranslation(final String key, final Locale locale) {
    final Optional<Translation> optional = i18nCache.get(key, locale);
    if (!optional.isPresent()) {
        return key;
    }
    return optional.get().getText();
  }
}