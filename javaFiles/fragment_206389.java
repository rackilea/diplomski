java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("HH:mm:ss");
    Date first = format.parse("10:33:12");
    Date second = format.parse("11:22:21");

    Date next = first;
    do {
        System.out.println(format.format(next));
    } while ((next = new Date(next.getTime() + 1000)).before(second));