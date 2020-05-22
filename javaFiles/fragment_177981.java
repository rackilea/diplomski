public static ComponentOrientation getOrientation(Locale locale) 
{
        // A more flexible implementation would consult a ResourceBundle
        // to find the appropriate orientation.  Until pluggable locales
        // are introduced however, the flexiblity isn't really needed.
        // So we choose efficiency instead.
        String lang = locale.getLanguage();
        if( "iw".equals(lang) || "ar".equals(lang)
            || "fa".equals(lang) || "ur".equals(lang) )
        {
            return RIGHT_TO_LEFT;
        } else {
            return LEFT_TO_RIGHT;
        }
}