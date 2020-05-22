public void onClick(View v) {
              if (view.getId() == R.id.btnGetLocation)
                 if (mGoogleApiClient != null) {
                     if (mGoogleApiClient.isConnected()) {
                         getMyLocation();
                     } else {
                         Toast.makeText(AddEditActivity.this,
                             "!mGoogleApiClient.isConnected()", Toast.LENGTH_LONG).show();
                     }
                  } else {
                      Toast.makeText(AddEditActivity.this,
                          "mGoogleApiClient == null", Toast.LENGTH_LONG).show();
                  }
             }