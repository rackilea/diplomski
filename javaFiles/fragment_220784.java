if(StringUtils.length(pattern) == StringUtils.length(value)) {
  try {
    DateFormat dateFormat = new SimpleDateFormat(pattern);
    dateFormat.setLenient(false);
    Date date = dateFormat.parse(value);
    if (date != null) {
      return true;
    }
  } catch (ParseException e) {}
}
return false;