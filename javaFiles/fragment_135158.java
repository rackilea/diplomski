public static void startEndDate(int endDay)
{
    LocalDate date = Year.of(2020).atDay(endDay);
    System.out.println("For the given end day of " + endDay
                        + " the date returned is : " + date);
}