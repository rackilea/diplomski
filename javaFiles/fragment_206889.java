String date="9:5 PM";

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm aa",Locale.getDefault());

        try {
            Log.e("",""+new SimpleDateFormat("HH:mm",Locale.getDefault()).format(simpleDateFormat.parse(date)));

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }