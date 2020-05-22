System.out.print("Enter Time-in(hh:mm)");
    String start=input.next(); //make sure it have "hh:mm" format
    LocalTime userTime = LocalTime.parse(start);
    LocalTime currentTime = LocalTime.now();


    long diff = ChronoUnit.HOURS.between(currentTime, userTime);