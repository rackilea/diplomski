@InitBinder
public void registerDateBinder(WebDataBinder binder) {
    DateFormat printFormat = new SimpleDateFormat(DateTimeFormat.patternForStyle("S-", LocaleContextHolder.getLocale())); // format for joda time dojo UI
    printFormat.setLenient(false);
    DateFormat sortFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy" , LocaleContextHolder.getLocale()); // NO LOCALE PlEASE!!!!!!
    sortFormat.setLenient(false);
    binder.registerCustomEditor(Date.class, new ExpandableCustomDateEditor(printFormat, Arrays.asList(printFormat, sortFormat), true));