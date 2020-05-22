public class LoggingMessageSource implements MessageSource {

  private MessageSource pathtru;

  public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
    // ...
  }

  public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
    // ...
  }

  public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
    // ...
  }
}