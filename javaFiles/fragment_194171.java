final Calendar cal = Calendar.getInstance();
final Random rand = new Random();
final SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");

cal.set(Calendar.YEAR, 2014);
cal.set(Calendar.DAY_OF_YEAR, rand.nextInt(cal.getActualMaximum(Calendar.DAY_OF_YEAR)) + 1);

System.out.println(format.format(cal.getTime()));