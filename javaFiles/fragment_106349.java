String first =  "1:12.203";
    String second = "1:04.009";

    SimpleDateFormat formater = new SimpleDateFormat("mm:ss.SSS");

    try {
        Date dateStart = formater.parse(first);
        Date dateEnd = formater.parse(second);

        long milliSeconds = dateStart.getTime() - dateEnd.getTime(); 

        Date timeDiff = new Date(milliSeconds);

        System.out.println(formater.format(timeDiff));
    } catch (ParseException e) {
        e.printStackTrace();
    }