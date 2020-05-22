LocalDate today = LocalDate.now();
    LocalDate tomorrow = LocalDate.now().plusDays(1);
    LocalDate yesterday = LocalDate.now().minusDays(1);

    if(today.isAfter(yesterday) && today.isBefore(tomorrow))
        System.out.println("Today is... today!");