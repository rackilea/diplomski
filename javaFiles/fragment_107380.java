btnAddFavourite = (ImageButton) findViewById(R.id.btnAddFavourite);

btnAddFavourite.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // Add code here to save the favourite, e.g. in the db.
        }
    });

btnAddFavourite.setOnLongClickListener(new View.OnLongClickListener() {

        @Override
        public boolean onLongClick(View v) {

            // Open the favourite Activity, which in turn will fetch the saved favourites, to show them.
            Intent intent = new Intent(getApplicationContext(), FavViewActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(intent);

            return false;
        }
    });