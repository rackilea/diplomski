LocalDate oldDate = LocalDate.of(2019,3,31);
    LocalDate newDate = LocalDate.of(2019,4, 1);
    System.out.println(oldDate.isAfter(newDate));
    System.out.println(oldDate.isBefore(newDate));
    System.out.println(oldDate.isEqual(newDate));
    System.out.println(oldDate.compareTo(newDate));