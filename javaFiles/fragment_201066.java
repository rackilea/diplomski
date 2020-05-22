private void getGooglePlaces(GooglePlacesListener finishedListener) {
        try {   
            iGPlaceApi.getStreams(itemsPerPage, pageNumber * itemsPerPage, new Callback<GooglePlacesApiResponse>() {

                @Override
                public void failure(RetrofitError retrofitError) {
                    finishedListener.onFailure();
                }

                @Override
                public void success(mGooglePlacesApiResponse obj, Response arg1) {
                    String[][] pArray = new String[obj.results.size()][4];
                    for (int i = 0; i < obj.results.size(); i++) {
                        mGooglePlaces.place place = obj.results.get(i);
                        pArray[i][0] = place.icon;
                        pArray[i][1] = place.name;

                    }
                    finishedListener.onRetrieved(pArray);
                }
            });
    }

  public interface GooglePlacesListener {
       void onRetrieved(String[][] places);
       void onFailure();
  }