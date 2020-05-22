if(localName.equals("startDate") && currentValue!=null){

    try {
        myObject.setStartDate(format.parse(currentValue));
    } catch (ParseException e) {
        String  dates [] = currentValue.split(" ");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dates[1]));
        cal.set(Calendar.YEAR, Integer.parseInt(dates[3]));
        cal.set(Calendar.MONTH, StaticDataUtils.months.get(dates[2]));
        String hours [] = dates[4].split(":");
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours[0]));
        cal.set(Calendar.MINUTE, Integer.parseInt(hours[1]));
        myObject.setStartDate(cal.getTime());
        e.printStackTrace();
    }