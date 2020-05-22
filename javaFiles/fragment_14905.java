Calendar calendar1 = Calendar.getInstance();
SimpleDateFormat formatter1 = new SimpleDateFormat("dd/M/yyyy h:mm");
String currentDate = formatter1.format(calendar1.getTime());

final String dateString = cursor.getString(4);
final String timeString = cursor.getString(5);
String datadb =dateString+" "+timeString;

//  Toast.makeText(context,"databse date:-"+datadb+"Current Date :-"+currentDate,Toast.LENGTH_LONG).show();

if(currentDate.compareTo(datadb)>=0) {
    myCheckBox.setChecked(true);
    myCheckBox.setEnabled(false);
}