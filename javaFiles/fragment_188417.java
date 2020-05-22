class GlobalSettings {
  private static Locale locale = Locale.US;

  public static Locale getLocale() {
    return locale;
  }

  public static void setLocale(Locale newValue) {
    locale = newValue;
  }
}