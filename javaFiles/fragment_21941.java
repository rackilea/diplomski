SimpleDateFormat format1 = new SimpleDateFormat("yyDDD");
     SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

     String oldDate = "12060";
     Date d = format1.parse(oldDate);
     String newDate = format2.format(d)

     System.out.println(newDate);