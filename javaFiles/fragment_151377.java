//getting month names
DateFormatSymbols dfs = new DateFormatSymbols();
String[] months = dfs.getMonths();

//here is what you need
Calendar c = Calendar.getInstance();
System.out.println(c.getTime().toString());
c.add(Calendar.MONTH, -12);
for (int i = -12; i <=12; i++){
    c.add(Calendar.MONTH, +1);
    System.out.println(months[c.get(Calendar.MONTH)]);
}