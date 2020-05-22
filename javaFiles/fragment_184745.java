closeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent= new Intent(getApplicationContext(), ActivityOne.class);
intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
startActivity(intent);
            }
        });