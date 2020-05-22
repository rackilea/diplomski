public static String[] splitYears(String str) {
    // get the year part of the string using a regex
    Matcher m = Pattern.compile("^\\[([\\d^K]+)\\]").matcher(str);
    if(m.find()) {
        String yearPart = m.group(1);
        // separate the other parts. The + 2 here is to account for the two square brackets in the yearPart
        String otherParts = str.substring(yearPart.length() + 2);
        // split by ^K
        String[] years = yearPart.split("\\^K");
        // Construct a new string for each year
        String[] newYears = new String[years.length];
        for (int i = 0; i < years.length; i++) {
            newYears[i] = String.format("[%s]%s", years[i], otherParts);
        }
        return newYears;
    } else {
        return new String[] {str};
    }
}