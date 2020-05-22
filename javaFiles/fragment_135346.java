public void addListenerOnButton() {

    final Context context = this;

    button = (Button) findViewById(R.id.button_10_oda);

    button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {

            Intent intent = new Intent(context, _tiz_vissza.class);
            startActivity(intent);   

    }

    otherButton = (Button) findViewById(R.id.button_10_megallok_oda);

    otherButton .setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {

            Intent intent = new Intent(context, _tiz_megallok_oda.class);
            startActivity(intent);

       }
});