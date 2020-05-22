for (String candidate : isoCountryCodes) {
    Locale locale = new Locale("", candidate);
    if (locale.getDisplayCountry().equals(mSpinner.getSelectedItem())) {
        mCountryCode = candidate;
        break;
    }
}