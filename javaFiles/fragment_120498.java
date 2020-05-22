for (int c = 0; c <= punk1.size()-1; c++) {
    if (punk1.get(c).matches("\\.")) {
        fullstop += 1;
    } else if (punk1.get(c).matches(",")) {
        comma += 1;
    } else if (punk1.get(c).matches("\\?")) {
        qmark += 1;
    } else if (punk1.get(c).matches("!")) {
        expoint += 1;
    } else if (punk1.get(c).matches("\"")) {
        doublequote += 1;
    } else if (punk1.get(c).matches("\'")){
        singlequote += 1;
    } else {
        System.out.println("Punctuation Marks not Found");
    }
}