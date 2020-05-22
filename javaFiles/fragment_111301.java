private Map<Locale, String> translations = new HashMap<>();

/** static: this instance is not modified or bound, it can be reused for multiple instances */
private static final ResourceBundle.Control CONTROL = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_PROPERTIES);

@Nullable
public String getTranslation(@NotNull Locale locale)
{
    List<Locale> localeCandidates = CONTROL.getCandidateLocales("_dummy_", locale); // Sun's implementation discards the string argument
    for (Locale currentCandidate : localeCandidates)
    {
        String translation = translations.get(currentCandidate);
        if (translation != null)
            return translation;
    }
    return null;
}