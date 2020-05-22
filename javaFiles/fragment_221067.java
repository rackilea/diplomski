plyerInvinc.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String code = full_code + "\n test";
                    //Here pass code to the activity in which you want to set the EDitText                
                    goBackToNew(v); // this is a function for switching activities.
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        }
);