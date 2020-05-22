SimpleDateFormat sdf = new SimpleDateFormat("EEE/MMM/dd/kk/mm/ss/zzzz/yyyy");
String date = tweet[0].replaceAll(" ","/");
if (date.split("/")[6].length() == 4) {
    date = new StringBuilder(date).insert(20, "+").toString();
}
Date d = sdf.parse(date);
System.out.println(new SimpleDateFormat("MM/dd/yyyy kk:mm:ss").format(d));