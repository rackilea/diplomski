String date1 = "2017-11-02";

DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
LocalDate localDate = formatter.parseLocalDate(date1);
DateTime newDate= localDate.toDateTime(new LocalTime());
someHibernateMethod.setTransactionDate1(newDate)