public static Date stringToDate(String string, final String format, final Locale locale) throws ParseException {
  ThreadLocal formater = new ThreadLocal() {
    protected SimpleDateFormat initialValue() {
      return new SimpleDateFormat(format, locale);
    }
  };
  return ((SimpleDateFormat)formater.get()).parse(string);
}

Date date = stringToDate(register_textview_birthday.getText().toString().trim(), "dd.MM.yyyy", Locale.ENGLISH);