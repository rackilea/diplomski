public static void main(String args[]) {
    final Calendar calendar = Calendar.getInstance();
    final String format = "{0,choice,0#midnight|0<am|12#noon|12<pm} {1,date,dd MMM YYYY HH:mm:ss}";
    final MessageFormat messageFormat = new MessageFormat(format);

    System.out.println(messageFormat.format(new Object[]{calendar.get(Calendar.HOUR_OF_DAY), calendar.getTime()}));
    System.out.println("==== TESTS ====");
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    System.out.println(messageFormat.format(new Object[]{calendar.get(Calendar.HOUR_OF_DAY), calendar.getTime()}));
    calendar.set(Calendar.HOUR_OF_DAY, 1);
    System.out.println(messageFormat.format(new Object[]{calendar.get(Calendar.HOUR_OF_DAY), calendar.getTime()}));
    calendar.set(Calendar.HOUR_OF_DAY, 11);
    System.out.println(messageFormat.format(new Object[]{calendar.get(Calendar.HOUR_OF_DAY), calendar.getTime()}));
    calendar.set(Calendar.HOUR_OF_DAY, 12);
    System.out.println(messageFormat.format(new Object[]{calendar.get(Calendar.HOUR_OF_DAY), calendar.getTime()}));
    calendar.set(Calendar.HOUR_OF_DAY, 14);
    System.out.println(messageFormat.format(new Object[]{calendar.get(Calendar.HOUR_OF_DAY), calendar.getTime()}));
}