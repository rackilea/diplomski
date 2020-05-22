Date date = new Date();
    int hours = date.getHours();

    if ( hours < 10) {
        System.out.println("before 10 am");
    } else {
        System.out.println("after 10 am");
    }

    // if deprecated methods are an issue then
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);

    int calHours = cal.get(Calendar.HOUR_OF_DAY);
    if ( calHours < 10) {
        System.out.println("before 10 am");
    } else {
        System.out.println("after 10 am");
    }