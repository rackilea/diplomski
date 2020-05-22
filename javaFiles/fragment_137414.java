private void setLanguage(final String option) {

    language = new Locale(option);

    if (t != null) {
    int result = t.setLanguage(language)
    // Check the result to see if it was successful
    } else {
    // the tts object was null?
    }

}