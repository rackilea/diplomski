@Override
public Object stringToValue(String text) throws ParseException {
  try {
    return ...;
  } catch (DateTimeParseException ex) {
    throw (ParseException) new ParseException(
      ex.getMessage(), ex.getErrorIndex()).initCause(ex);
  }