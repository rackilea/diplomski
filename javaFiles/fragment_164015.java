....
    pause = myInflatedView.findViewById(R.id.buttonpause);
    pause.setBackgroundResource(R.drawable.pause);
    showdate = myInflatedView.findViewById(R.id.textViewDate);
    showdate2 = myInflatedView.findViewById(R.id.textViewDate2);

    // Get Rid of All of this!!
    //calendar = Calendar.getInstance();
    //calendar2 = Calendar.getInstance();
    //simpleDateFormat = new SimpleDateFormat("dd mm yyyy HH:mm:ss");
    //Date = simpleDateFormat.format(calendar.getTime());
    //Date2 = simpleDateFormat.format(calendar2.getTime());


    pause.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             if (isPressed) {
                 view.setBackgroundResource(R.drawable.pause);
                 String now = getDateNow();
                 long nowLong = getMillisecondsNow();
                 Log.e("My Time Milli 1 = ", "" + nowLong )
                 //Date2 = simpleDateFormat.format(calendar.getTime());
                 showdate2.setText(now);

             }else {
                 view.setBackgroundResource(R.drawable.start);
                 String now = getDateNow();
                 long nowLong = getMillisecondsNow();
                 Log.e("My Time Milli 2 = ", "" + nowLong )
                 //Date = simpleDateFormat.format(calendar.getTime());
                 showdate.setText(now);
             }
             isPressed = !isPressed;
         }
     });

    private String getDateNow() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(""dd mm yyyy HH:mm:ss"");
        return sdf.format(cal.getTime());       
    }