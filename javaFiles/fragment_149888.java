//set up click event for database
    AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(final AdapterView parent, View v, final int position, long id) {
            //link image view
            ImageView iv = (ImageView) findViewById(R.id.cardDisplay);
            //link scrollable textview
            TextView tv = (TextView) findViewById(R.id.cardDataDisplay);
            // Do something in response to the click
            //set image id
            int imageId = database.get(position).getCardImgID();
            //display image to imageview
            iv.setImageResource(imageId);

            //Configure button click event
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //add card from database to current deck
                    currentDeck.add(database.get(position));
                    adapter2.notifyDataSetChanged();
                }
            });