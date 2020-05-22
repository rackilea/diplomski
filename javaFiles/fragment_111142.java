public class DateTimeFromTimestampEditor extends PropertyEditorSupport {

  @Override
  public String getAsText() {
    return Long.toString(((DateTime) getValue()).getMillis());
  }

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    setValue(new DateTime(Long.parseLong(text), DateTimeZone.UTC));
  }

}