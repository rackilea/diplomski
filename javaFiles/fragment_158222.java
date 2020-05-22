public class CustomMessageSource extends ResourceBundleMessageSource {

    private String prefix;
    private String suffix;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        if(code.startsWith("typeMismatch"))
            return this.prefix + super.getMessage(resolvable, locale) + this.suffix;

        if(code.startsWith("errors"))
            return this.prefix + super.getMessage(resolvable, locale) + this.suffix;

        return super.getMessage(code, args, defaultMessage, locale);
    }

    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        if(code.startsWith("typeMismatch"))
            return this.prefix + super.getMessage(resolvable, locale) + this.suffix;

        if(code.startsWith("errors"))
            return this.prefix + super.getMessage(resolvable, locale) + this.suffix;

        return super.getMessage(code, args, locale);
    }

    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        String [] errors = resolvable.getCodes();
        for(String error: errors) {
            if(error.startsWith("typeMismatch"))
                return this.prefix + super.getMessage(resolvable, locale) + this.suffix;

            if(error.startsWith("errors"))
                return this.prefix + super.getMessage(resolvable, locale) + this.suffix;
        }

        return super.getMessage(resolvable, locale);
    }

}