public static void main(String[] args) throws Exception {


    String isoDate = "2016-07-09T01:30:00.0";
    //  ISO Local Date and Time '2011-12-03T10:15:30'
    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    LocalDateTime dateTimeParked = LocalDateTime.parse(isoDate, formatter);
    System.out.println(dateTimeParked);




    String date = "2016-07-09 01:30:00.0";
    DateTimeFormatter formatterNew = DateTimeFormatter.ofPattern("yyyy-LL-dd HH:mm:ss.S");
    LocalDateTime dateTimeParkedNew = LocalDateTime.parse(date, formatterNew);      
    System.out.println(dateTimeParkedNew);

}