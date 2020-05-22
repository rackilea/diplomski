Calendar cal = Calendar.getInstance();
cal.clear();
cal.set(1986, 8, 20);
int year = cal.get(Calendar.YEAR);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
while (year >= cal.get(Calendar.YEAR)) {
    cal.add(Calendar.DAY_OF_MONTH, 7);
    System.out.println(sdf.format(cal.getTime()));
}