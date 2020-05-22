Calendar calendar = Calendar.getInstance();
   int time = c.get(Calendar.HOUR_OF_DAY);

    if(time >= 6 && time < 18){

    image.setImageResource(R.drawable.morning);     

     }else if (time >= 18 && time < 6){

    image.setImageResource(R.drawable.night);

    }