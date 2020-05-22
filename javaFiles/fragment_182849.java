SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
GregorianCalendar input = new GregorianCalendar();
int ordinal = 3;
int weekday = Calendar.SUNDAY;

GregorianCalendar start =
    new GregorianCalendar(input.get(Calendar.YEAR), input.get(Calendar.MONTH), 1);
int dow = start.get(Calendar.DAY_OF_WEEK); // Sun=1, Mon=2, ...
int delta = (weekday - dow);
if (delta < 0) {
    delta += 7;
}
start.add(Calendar.DAY_OF_MONTH, delta + (ordinal - 1) * 7);
String comp1 = sdf.format(input.getTime());
String comp2 = sdf.format(start.getTime());
boolean isThirdSundayInMonth = comp1.equals(comp2);