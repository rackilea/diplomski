shar_btn = (Button) findViewById(R.id.shrbtn);

shar_btn.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkAndRequestPermissions()) {
                    // call comman function that you want to execute
                    shareLocation();
                }
            }

        });