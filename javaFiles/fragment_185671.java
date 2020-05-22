LocalDate dateToDo = LocalDate.parse(request.getParameter("date")); //for example 2019-08-31

    LocalDate today = LocalDate.now(ZoneId.of("Europe/Minsk"));
    LocalDate tomorrow = today.plusDays(1);

    if(dateToDo.equals(today)){
        System.out.println("Today!");
    } else if (dateToDo.equals(tomorrow)){
        System.out.println("Tomorrow!");
    } else {
        System.out.println("OTHER DAY");
    }