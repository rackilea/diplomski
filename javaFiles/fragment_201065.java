private String[][] GetGooglePlaces(List<NameValuePair>[] nameValuePairs) {
    String[][] pArray = null;

        CountDownLatch countDownLatch = new CountDownLatch(1); // Set up a latch 

        try {   
            iGPlaceApi.getStreams(itemsPerPage, pageNumber * itemsPerPage, new Callback<mGooglePlacesApiResponse>() {

                @Override
                public void failure(RetrofitError retrofitError) {
                    //TODO
                }

                @Override
                public void success(mGooglePlacesApiResponse obj, Response arg1) {
                    pArray = new String[obj.results.size()][4];
                    for (int i = 0; i < obj.results.size(); i++) {
                        mGooglePlaces.place place = obj.results.get(i);
                        pArray[i][0] = place.icon;
                        pArray[i][1] = place.name;

                    }
                    countDownLatch.countDown(); // unlock the latch when you get your callback
                }
            });

        try {
            countDownLatch.await(30, TimeUnit.SECONDS);  // make it wait before you return
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return pArray;
    }