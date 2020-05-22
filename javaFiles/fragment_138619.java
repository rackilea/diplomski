static String[] suffixes =
          //    0     1     2     3     4     5     6     7     8     9
             { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
          //    10    11    12    13    14    15    16    17    18    19
               "th", "th", "th", "th", "th", "th", "th", "th", "th", "th",
          //    20    21    22    23    24    25    26    27    28    29
               "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
          //    30    31
               "th", "st" };

public static void main(String args[]) throws ParseException {
    String string = "2013-01-10 09:49:19";
    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(string);
    SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
    String dayStr =
            dayFormat.format(date)
                    + suffixes[Integer.parseInt(dayFormat.format(date))]
                    + " " + monthFormat.format(date) + ".";
    System.out.println(dayStr);
}