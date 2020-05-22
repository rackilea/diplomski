FileWriter fileWriter = new FileWriter("myFile");
    Calendar now = new GregorianCalendar();

    Calendar c = new GregorianCalendar();
    c.set(Calendar.HOUR_OF_DAY, 0);
    c.set(Calendar.MINUTE, 0);

    DateFormat df = new SimpleDateFormat("HH:mm");
    while (c.before(now)) {
        c.add(Calendar.MINUTE, 1);
        fileWriter.write(df.format(c.getTime())+System.lineSeparator());
    }

    fileWriter.close();