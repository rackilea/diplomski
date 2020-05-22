LocalDate d=LocalDate.of(yy,mm,dd);
    LocalDate d2=LocalDate.of(yy, mm, dd);
    Period p=Period.between(d, d2);
    long day,month,year;
    day=p.getDays();
    month=p.getMonths();
    year=p.getYears();
    System.out.println(day+" : "+month+" : "+year);