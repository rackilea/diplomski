public static void main(String args[]) throws Exception {
    String a = "2019-05-10";    // ISO date format
    String b = "2019-5-10";     // date format with only a single digit for month
    LocalDate ldA = makeItIsoFormat(a);
    LocalDate ldB = makeItIsoFormat(b);
    // note the lower case year and day, month stays upper case
    System.out.println(ldA.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日", Locale.JAPAN)));
    System.out.println(ldB.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日", Locale.JAPAN)));
}

public static LocalDate makeItIsoFormat(String date) {
    // first, split the input String by a hyphon
    String[] splitDate = date.split("-");

    // check its length, it has to have 3 parts (year, month, day)
    if (splitDate.length != 3) {
        // if it has more or less parts, the date is considered invalid
        System.err.println("invalid date String provided");
    } else {
        // otherwise, check the amount of digits it has for month
        if (splitDate[1].length() == 1) {
            // and if it is just one, add a leading zero
            System.out.println("The given date \"" 
                    + date 
                    + "\" has a single digit for month, add leading zero");
            splitDate[1] = "0" + splitDate[1];
        }
    }

    /*
     * CONSIDER ADDING A CHECK FOR SINGLE-DIGIT DAYS, it is not yet included
     */

    // recreate the date String
    String isoDate = splitDate[0] + "-" + splitDate[1] + "-" + splitDate[2];
    // and return the parsed LocalDate
    return LocalDate.parse(isoDate, DateTimeFormatter.ISO_DATE);
}