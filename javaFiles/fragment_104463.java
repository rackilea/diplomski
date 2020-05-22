public boolean isNumeric(String s) {
    try {
        Double.parseDouble(s);
        return true;
    } catch (NumberFormatException nfe) {
        return false;
    }
}