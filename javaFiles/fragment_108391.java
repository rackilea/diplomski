placesRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            List<Places> placesList = new ArrayList<>();
            for (DocumentSnapshot document : task.getResult()) {
                Places places = document.toObject(Places.class);
                placesList.add(places);
            }

            int placeCount = placesList.size();
            Random randomGenerator = new Random();
            List<Places> randomPlaceList = new ArrayList<>();
            for (int i = 1; i <= 3; i++) {
                randomPlaceList.add(placesList.get(randomGenerator.nextInt(placeCount)));
            }
            ListView mListView = (ListView) findViewById(R.id.place_list);
            PlacesAdapter placesAdapter = new PlacesAdapter(getApplicationContext(), randomPlaceList);
            mListView.setAdapter(placesAdapter);
        }
    }
});