Calendar calendar = Calendar.getInstance();

    int tHour = calendar.get(Calendar.HOUR_OF_DAY);
    int tmin = calendar.get(Calendar.MINUTE);

    if (tHour = 19 && tmin > 0 && tmin<30){
        btn.setEnabled(true);
    }else{
        btn.setEnabled(false);
    }