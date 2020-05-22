boolean validate(String date, String pattern) throws ParseException {
    String regex = pattern.replaceAll("\\w", "\\\\d").replace(".", "\\.");
    if (!date.matches(regex)) {
        return false;
    }
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    sdf.setLenient(false);
    try {
        sdf.parse(date);
    } catch (Exception e) {
        return false;
    }
    return true;
}