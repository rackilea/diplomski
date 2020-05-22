final class DefaultDateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

  // TODO: migrate to streaming adapter

  private final DateFormat enUsFormat;
  private final DateFormat localFormat;

  DefaultDateTypeAdapter() {
    this(DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.US),
        DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT));
  }

  DefaultDateTypeAdapter(String datePattern) {
    this(new SimpleDateFormat(datePattern, Locale.US), new SimpleDateFormat(datePattern));
  }

  DefaultDateTypeAdapter(int style) {
    this(DateFormat.getDateInstance(style, Locale.US), DateFormat.getDateInstance(style));
  }

  public DefaultDateTypeAdapter(int dateStyle, int timeStyle) {
    this(DateFormat.getDateTimeInstance(dateStyle, timeStyle, Locale.US),
        DateFormat.getDateTimeInstance(dateStyle, timeStyle));
  }

  DefaultDateTypeAdapter(DateFormat enUsFormat, DateFormat localFormat) {
    this.enUsFormat = enUsFormat;
    this.localFormat = localFormat;
  }

  // These methods need to be synchronized since JDK DateFormat classes are not thread-safe
  // See issue 162
  @Override
  public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
    synchronized (localFormat) {
      String dateFormatAsString = enUsFormat.format(src);
      return new JsonPrimitive(dateFormatAsString);
    }
  }

  @Override
  public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    if (!(json instanceof JsonPrimitive)) {
      throw new JsonParseException("The date should be a string value");
    }
    Date date = deserializeToDate(json);
    if (typeOfT == Date.class) {
      return date;
    } else if (typeOfT == Timestamp.class) {
      return new Timestamp(date.getTime());
    } else if (typeOfT == java.sql.Date.class) {
      return new java.sql.Date(date.getTime());
    } else {
      throw new IllegalArgumentException(getClass() + " cannot deserialize to " + typeOfT);
    }
  }

  private Date deserializeToDate(JsonElement json) {
    synchronized (localFormat) {
      try {
        return localFormat.parse(json.getAsString());
      } catch (ParseException ignored) {}
      try {
        return enUsFormat.parse(json.getAsString());
      } catch (ParseException ignored) {}
      try {
        return ISO8601Utils.parse(json.getAsString(), new ParsePosition(0));
      } catch (ParseException e) {
        throw new JsonSyntaxException(json.getAsString(), e);
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(DefaultDateTypeAdapter.class.getSimpleName());
    sb.append('(').append(localFormat.getClass().getSimpleName()).append(')');
    return sb.toString();
  }
}