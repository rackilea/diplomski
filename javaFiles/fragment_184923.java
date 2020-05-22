SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Calendar calendar = Calendar.getInstance();
    String dateIs = dateFormat.format(calendar.getTime());
    if (departureTime.reverse().substring(0,2).equalsIgnoreCase(arrivalTime.reverse().substring(0,2))) {
        departureTime.reverse().insert(0, dateIs + " ");
        arrivalTime.reverse().insert(0, dateIs + " ");
    } else {
        departureTime.reverse().insert(0, dateIs + " ");
        calendar.add(Calendar.DATE, 1);
        arrivalTime.reverse().insert(0,dateFormat.format(calendar.getTime()) +" ");
    }
    dateFormat.applyPattern("dd/MM/yyyy hh:mm aa");
    Date dateOne = dateFormat.parse(departureTime.toString());
    Date dateTwo = dateFormat.parse(arrivalTime.toString());

    DurationFormatUtils.formatDurationHMS(dateTwo.getTime() - dateOne.getTime());
    System.out.println(DurationFormatUtils.formatDurationWords(dateTwo.getTime() -
                                                               dateOne.getTime(),
                                                               true, true));