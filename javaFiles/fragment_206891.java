String date=pad(Integer.parseInt(hour)) + ":" + pad(minute) + " " + meridiem;

         SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm aa",Locale.getDefault());

        try {
            editTime.setText(""+new SimpleDateFormat("HH:mm",Locale.getDefault()).format(simpleDateFormat.parse(date)));

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }