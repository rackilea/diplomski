int oldDay = oDate.get(Calendar.DAY_OF_MONTH);
    oDate.add(Calendar.MONTH, 1);

    // If the old DAY_OF_MONTH was larger than our new one, then
    // roll over to the beginning of the next month.
    if (oldDay > oDate.get(Calendar.DAY_OF_MONTH)){
        oDate.add(Calendar.MONTH, 1);
        oDate.set(Calendar.DATE, 1);
    }

    String sTodayDate2 = Sdf.format( oDate.getTime() );