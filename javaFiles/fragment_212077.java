Button button = (Button) findViewById(R.id.button1);

    //Your mistake is on this line.
    button.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
        }

    });