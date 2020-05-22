private String stripAccents(final String s) {
    if(s == null) {
        return "";
    }
    return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").replaceAll("ø", "o");
}