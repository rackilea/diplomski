Calendar cal = Calendar.getInstance();
cal.set(Calendar.DATE, 1);

while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
    cal.add(Calendar.DATE, 1);
}