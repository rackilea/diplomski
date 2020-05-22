// Had this
horizontalGridView = (HorizontalGridView) findViewById(R.id.gridView);
GridElementAdapter adapter = newGridElementAdapter(VenueProfileActivity.this, mDeals);
horizontalGridView.setAdapter(adapter);

// This needed to be added
HorizontalGridView.LayoutManager layoutManager = new LinearLayoutManager(VenueProfileActivity.this, LinearLayoutManager.HORIZONTAL, false);
horizontalGridView.setLayoutManager(layoutManager);
horizontalGridView.setHasFixedSize(true);