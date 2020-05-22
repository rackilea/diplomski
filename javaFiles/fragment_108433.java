String completionDate1 = "21/10/2016";
 System.out.println(completionDate1);
 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
 Date date = new Date();
 date = df.parse(completionDate1);
 DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
 System.out.println(df1.format(date));