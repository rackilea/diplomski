lvVenue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
                               int position, long id) {
            GetVenue getVenue = venuelist.get(position);//using position int get correspondig data
            Intent appInfo = new Intent(MainMenu.this, VenueActivity.class);
            startActivity(appInfo);
        }
    });