String sDate = "07/08/2017";
String eDate = "07/10/2017";

DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
DateTimeFormatter format2 = DateTimeFormatter.ofPattern("ddMMyyyy");
DateTimeFormatter format3 = DateTimeFormatter.ofPattern("yyyyMM");

LocalDate dateStart = LocalDate.from(LocalDate.parse(sDate, format1).withDayOfMonth(1)); // just getting the month and year from user input and start with first day of given month
LocalDate dateEnd = LocalDate.from(format1.parse(eDate));
while (!dateStart.isAfter(dateEnd)) {
    System.out.println("date1 : "+dateStart.format(format3) + " - date2: " + dateStart.format(format2));
    dateStart = dateStart.plusDays(1);
}