btnStart.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
ntent intent = new Intent(Main.this, Service_class.class);

   intent.putExtra("strings", myStrings);
    startActivity(intent);
            startService(new Intent(getBaseContext(), Service_class.class));


        }
    });

    // click listener for the button to stop service
    Button btnStop = (Button) findViewById(R.id.button2);
    btnStop.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
ntent intent = new Intent(Main.this, Service_class.class);
           intent.putExtra("strings", myStrings);
    startActivity(intent);
            stopService(new Intent(getBaseContext(), Service_class.class));
        }
    });