String date = "2018/1/7".replaceAll("/(\\d)/(\\d)$", "/0$1/0$2");

DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
LocalDate localDate = LocalDate.parse(date, format);

return new int[]{
    localDate.getYear(),
    localDate.getMonthValue(),
    localDate.getDayOfMonth()
}