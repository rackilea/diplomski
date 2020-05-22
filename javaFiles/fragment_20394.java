query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<Places> placesList = new ArrayList<>();
                    for (DocumentSnapshot document : task.getResult()) {
                        Places place = document.toObject(Places.class);
                        placesList.add(place);
                    }                      
                    int placeCount = placesList.size();
                    Random randomGenerator = new Random();

                    randomPlaceList = new ArrayList<>(); //this is the activity's list
                    for (int i = 1; i <= 3; i++) {
                        randomPlaceList.add(placesList.get(randomGenerator.nextInt(placeCount)));
                    }
                    ListView mListView = (ListView) findViewById(R.id.place_list);
                    PlaceAdapter placeAdapter = new PlaceAdapter(randomPlaceList, getBaseContext());
                    mListView.setAdapter(placeAdapter);                    
            }
        });