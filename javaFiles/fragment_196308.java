String d1 = "21/1/2014";
String d2 = "19/1/2014";
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Date dateOne = sdf.parse(d1);
Date dateTwo = sdf.parse(d2);
long diff = dateOne.getTime() - dateTwo.getTime();
int differenceInDays = (int) (diff / 1000 / 60 / 60 / 24 / 1);
System.out.println(differenceInDays);