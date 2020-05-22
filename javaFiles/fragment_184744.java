launchActivityTwoButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent StartIntent = new Intent(getApplicationContext(), ActivityTwo.class);
    StartIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
    startActivity(StartIntent);
            }
        });