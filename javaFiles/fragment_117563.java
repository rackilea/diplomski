public static String convert (DateTime input) {
    int hours = (input.getDayOfMonth() - 1) * 24 + input.getHourOfDay();
    return String.format("%d:%02d",hours,input.getMinuteOfHour());
}

public static void main(String[] args) {
    System.out.println(convert(new DateTime("2014-01-01T22:09")) );
    System.out.println(convert(new DateTime("2014-01-03T22:21")) );
    System.out.println(convert(new DateTime("2014-01-31T22:44")) );
}