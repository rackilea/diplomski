String str = "12,2014-10-09 06:00:00,2014-10-09 "
    + "06:15:00,\"\",\"\",\"\",\"123,456\",\"\",\"9,999\",\"\",\"\"";
str = str.substring(str.indexOf(',') + 1);
str = str.replaceAll("\"(\\d+),(\\d+)\"", "$1$2").replace("\"", "");
String expected = "2014-10-09 06:00:00,2014-10-09 06:15:00,,,,123456,,9999,,";
System.out.println(str.equals(expected));