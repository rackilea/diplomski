Locale locale = new Locale("el", "GR");
SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, HH:mm", locale);
DateFormatSymbols dfs = DateFormatSymbols.getInstance(locale);
String[] months = {"Ιανουαρίου", "Φεβρουαρίου", "Μαρτίου", "Απριλίου", "Μαΐου", "Ιουνίου", "Ιουλίου", "Αυγούστου", "Σεπτεμβρίου", "Οκτωβρίου", "Νοεμβρίου", "Δεκεμβρίου"};
dfs.setMonths(months);
formatter.setDateFormatSymbols(dfs);

try {
     System.out.println(formatter.parse("28 Μαρτίου 2014, 14:00"));
     // output in my timezone: Fri Mar 28 14:00:00 CET 2014
} catch (ParseException ex) {
     ex.printStackTrace();
}