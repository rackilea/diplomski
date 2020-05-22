private void arrowClickListener = new View.OnClickListener(){
    @Override
    public void onClick(View view) {
        // clicked buttton -- pick layout based on button "state"
        int resId = isBtnClicked ? R.layout.cardview_expand_details : R.layout.cardview_refined;

        // set the contentview with the layout we determined earlier
        setContentView(resId);

        // If we're in the "normal" view, find the card art view and set our field to it
        if (!isBtnClicked){
            cardArtImageView = findViewById(R.id.cardArtImageView);
        }

        // do other initialization stuff
        viewDefinitions(isBtnClicked);
        initCardViewData(selectedItemPosition);
        setSelectedViewsInit();

        // set our new arrow button click listener to this listener
        arrowButton.setOnClickListener(arrowClickListener);

        // toggle button flag
        isBtnClicked = !isBtnClicked;
    }
}