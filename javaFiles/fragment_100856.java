public void processLines() {
    String regex = "\\D+";
    boolean isDigit = false;
    for (String s : lines) {
        isDigit = Pattern.matches(regex, s);
        log.info(s + "\t\t" + Boolean.toString(isDigit)
        );
    }
}