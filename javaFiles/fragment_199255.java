Calendar startDate = Calendar.getInstance();
startDate.set(2012, Calendar.DECEMBER, 02);
if (startDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
    System.out.println("true");
} else {
    System.out.println("FALSE");
}