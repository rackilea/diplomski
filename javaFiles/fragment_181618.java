DateTime start = new DateTime(datenaiss_chooz.getDate());
Years h = Years.yearsBetween(start, new DateTime()); 
StringBuilder b = new StringBuilder();
b.append(h.getYears());
String str = b.toString();
if ( h.getYears()==0)
age.setText(""); 
else
age.setText(str+" "+"ans");