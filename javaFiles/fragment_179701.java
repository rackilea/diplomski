button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String lat = String.valueOf(latitude);
            String lng = String.valueOf(longitude);
            databaseHelper.insert_location(lat,lng,locality,current_state,current_country);
            Toast.makeText(MapActivity.this, locality, Toast.LENGTH_SHORT).show();
        }