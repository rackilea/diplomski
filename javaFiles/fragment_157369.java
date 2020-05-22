@Autowired
private MessageSource messageSource;


someMethod(){
    String task = ...;
    String code = messageSource.getMessage("task_["+ task +"]", LocaleContextHolder.getLocale());
}