Calendar cal = Calendar.getInstance();
cal.setLenient(false);
cal.setTime(yourDate);
try {
    cal.getTime();
}
catch (Exception e) {
  System.out.println("Invalid date");
}