if(Build.VERSION.SDK_INT >= 16)     //The flag we used here was only added at API 16    
    myIntent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
    //use myIntent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND); if you want to add more than one flag to this intent;



PendingIntent pi = PendingIntent.getBroadcast(context, 1, myIntent, 0); // the requestCode must be different from 0, in this case I used 1;