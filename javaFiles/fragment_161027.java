SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
                Editor prefsEditor = appSharedPrefs.edit();

    Button b1 = (Button) findViewById(R.id.button1);
    b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                prefsEditor.putString("buttonPressed", "Button1");
                prefsEditor.commit();

                }
            });

    Button b2 = (Button) findViewById(R.id.button2);
    b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                prefsEditor.putString("buttonPressed", "Button2");
                prefsEditor.commit();

                }
            });

    Button b3 = (Button) findViewById(R.id.button3);
    b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                prefsEditor.putString("buttonPressed", "Button3");
                prefsEditor.commit();

                }
            });