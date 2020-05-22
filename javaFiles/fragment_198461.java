LocalDate startDate = LocalDate.of(2018, 01, 1);
    LocalDate endDate = LocalDate.of(2018, 03, 1);
    while(startDate.isBefore(endDate))
    {
        getUserForMonth(123,startDate.getYear(), startDate.getMonthValue());
        startDate = startDate.plusMonths(1);//.plusYears if you want years
    }