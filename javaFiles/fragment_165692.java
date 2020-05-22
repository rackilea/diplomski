Button mButton = (Button) findViewById(R.id.More);
    mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView mTextView = (TextView) findViewById(R.id.Antal);
                mTextView.setText("Some Text");
            }
        });