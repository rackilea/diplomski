public static void main(String[] args) {
    DateTime dt = DateTime.now();

    String usFormat = DateTimeFormat.patternForStyle("L-", Locale.US);
    String ukFormat = DateTimeFormat.patternForStyle("L-", Locale.UK);

    System.out.println(dt.toString(usFormat));
    System.out.println(dt.toString(ukFormat));
}