Locale locale = LocaleContextHolder.getLocale();
String datepickerLocale;
if(locale.getLanguage().equals("de")){
    datepickerLocale = "de"; // only "de", no country code
} else if (locale.getLanguage().equals("en")){
    if(locale.getCountry().equals("GB")){
        datepickerLocale = "en-GB"; // en-GB must be set explicitly
    } else if(locale.getCountry().equals("US")){
        datepickerLocale = ""; // en-US is default
    }
}
// [...] more locales if needed, see docs for Datepicker Localization
uiModel.addAttribute("datepickerLocale", datepickerLocale);