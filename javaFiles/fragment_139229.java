String startDate="06162019 00:00:00";
DateTimeFormatter inSDF = DateTimeFormatter.ofPattern("MMddyyyy HH:mm:ss");
DateTimeFormatter outSDF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
try{
   System.out.println(outSDF.format(inSDF.parse(startDate)));
}catch (Exception e) {
   e.getMessage();
}