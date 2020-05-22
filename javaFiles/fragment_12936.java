final TextView txt = (TextView) findViewById(R.id.spText);//Make txt final
    txt.setText(""+loadCoinsNumber("CoinsNumber")); // displaying the number of coins

    btnPlay = (Button) findViewById(R.id.btnPlay);
    btnPlay.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeCoinsNumber("CoinsNumber", 111);
            txt.setText(""+loadCoinsNumber("CoinsNumber"));//Adding this line to update
        }
    });