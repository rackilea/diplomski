private String getLangCode() {        
            String code = LOG.getResourceBundle().getLocale().getDisplayLanguage();
            if (StringUtils.isEmpty(code)) {
                return "en";
            }
            return code;
            }