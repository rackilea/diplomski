SharedPreferences prefs = getSharedPreferences("Your preference name here", MODE_PRIVATE) 


b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b2.setEnabled(true);
                prefs.edit().putBoolean("b2enabled", true).commit();//saving State here
            }
        });