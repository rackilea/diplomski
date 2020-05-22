Button button = (Button) buttonView.findViewById(R.id.trash);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click   
                Toast.makeText(getApplicationContext(), "this is my Toast message!!! =)",
                           Toast.LENGTH_LONG).show();
            }
        });