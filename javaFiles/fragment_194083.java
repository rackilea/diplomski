// TODO: Revisit the decision to make a field called "number"
// a string...
String getNumber(String language, String country) {
    for (MyObject candidate : list) {
        if (candidate.getLanguage().equals(language) &&
            candidate.getCountry().equals(country)) {
            return candidate.getNumber();
        }
    }
    // Or throw an exception, depending on what semantics are expected
    return null;
}