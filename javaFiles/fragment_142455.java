Date date2 = Calendar.getInstance().getTime();
DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss"); 
String strDate = dateFormat.format(date2);              
String fileName = "Date "+ strDate + ".csv";

for(int i = 0; i < list1.size(); i++) {
     writeToExcel(...);                    // REMOVE fileName FROM INSIDE METHOD
}