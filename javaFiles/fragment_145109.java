Locale locale = getLocaleBasingOnRequest(HttpServletRequest request); // read the locale sent by browser by accesing request.getLocales()

ResourceBundle bundle = ResourceBundle.getBundle("Translations_file", locale);
for (String key : bundle.keySet()) {
  System.out.println(key);
  System.out.println(bundle.getString(key));
}