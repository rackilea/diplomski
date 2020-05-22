protected Locale getLocaleFromParam(Object requestedLocale) {
        Locale locale = null;
        if (requestedLocale != null) {
            locale = (requestedLocale instanceof Locale) ?
                    (Locale) requestedLocale :
                    LocalizedTextUtil.localeFromString(requestedLocale.toString(), null);
            if (locale != null && LOG.isDebugEnabled()) {
                LOG.debug("applied request locale=#0", locale);
            }
        }

        if (locale == null) {
            locale = Locale.getDefault();
        }
        return locale;
    }