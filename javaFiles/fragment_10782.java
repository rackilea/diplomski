ImageView butt1 = (ImageView) findViewById(R.id.mainIconOnline);

        butt1.setOnClickListener(this);

@Override
    public void onClick(View v) {
        if (v.getId() == R.id.mainIconOnline) {

            Intent i = new Intent(this, SecondActivityclass);
        startActivity(i);

        }

    }