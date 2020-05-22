final class FallbackMessageSource implements MessageSource {
    private final MessageSource delegate;
    private final Locale fallbackLocale;

    public FallbackMessageSource(MessageSource delegate, Locale fallbackLocale) {
        this.delegate = delegate;
        this.fallbackLocale = fallbackLocale;
    }

    @Override
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        try {
            return delegate.getMessage(code, args, defaultMessage, locale);
        } catch(NoSuchMessageException ex) {
            return delegate.getMessage(code, args, defaultMessage, fallbackLocale);
        }
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        try {
            return delegate.getMessage(code, args, locale);
        } catch(NoSuchMessageException ex) {
            return delegate.getMessage(code, args, fallbackLocale);
        }
    }

    @Override
    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        try {
            return delegate.getMessage(resolvable, locale);
        } catch(NoSuchMessageException ex) {
            return delegate.getMessage(resolvable, fallbackLocale);
        }
    }
}