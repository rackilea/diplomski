// You can define those both textview globally.
   TextView tvC1HPLP = findViewById(R.id.errormsg);
   TextView tvok = findViewById(R.id.ok);

   Handler mHandler = new Handler();
   final Runnable runnable = new Runnable() {
     int count = 0;
     @Override
     public void run() {

         String sErrorList = errorList.get(count%errorList.size);
         String sErrorListOkBox = errorListOkBox.get(count%errorListOkBox.size);

         tvC1HPLP.setText(sErrorList);

         tvok.setText(sErrorListOkBox);
         rl.setBackgroundResource(R.drawable.errorred);
         tvC1HPLP.setTextColor(Color.RED);
         count++;
         mHandler.postDelayed(this, 4000); // four second in ms
     }
   };
   mHandler.postDelayed(runnable, 1000);