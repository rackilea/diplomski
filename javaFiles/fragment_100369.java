public static int countCommasAtBegin(String str) {
    Matcher commas = Pattern.compile("^,*").matcher(str);
    if (commas.find()) {
        return commas.group().length();
    } else {
        return 0;
    }
}