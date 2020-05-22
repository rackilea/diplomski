long militaryDate = 20151228L;
LocalDate ld = LocalDate.of((int) (militaryDate / 10000),
                            Month.of((int) (militaryDate / 100) % 100),
                            (int) (militaryDate % 100));

System.out.println(ld);