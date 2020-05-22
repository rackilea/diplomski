Calendar calendar = Calendar.getInstance();
   int time = c.get(Calendar.HOUR_OF_DAY);

    if(time >= 6 && time < 18){

    image.setImageResource(R.drawable.morning);     

     }else{

    image.setImageResource(R.drawable.night);

    }