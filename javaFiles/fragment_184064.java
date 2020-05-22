@Autowired
private MessageSource messageSource;

public String getMessage(String messageName) {
    return messageSource.getMessage(messageName, null, null);
}