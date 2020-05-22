DateTime dt = new DateTime(2005, 3, 26, 0, 0, 0, 0);

    Period everyMonth= Period.months(1);

    DateTime dt1 = dt.plus(everyMonth);
    DateTime dt2 = dt1.plus(everyMonth);
    DateTime dt3 = dt2.plus(everyMonth);
    DateTime dt4 = dt3.plus(everyMonth);
    DateTime dt5 = dt4.plus(everyMonth);

    System.out.println(dt.toDate());
    System.out.println(dt1.toDate());
    System.out.println(dt2.toDate());
    System.out.println(dt3.toDate());
    System.out.println(dt4.toDate());
    System.out.println(dt5.toDate());