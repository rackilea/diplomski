@Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == AUTOCOMPLETE_REQUEST_CODE) {
      if (resultCode == RESULT_OK) {

        Place place = Autocomplete.getPlaceFromIntent(data);
        //Toast.makeText(MyActivity.this, place.getName(), Toast.LENGTH_SHORT).show();

        mEditInit.setText(place.getName());
      } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
        // TODO: Handle the error.
        Status status = Autocomplete.getStatusFromIntent(data);
        // Log.i(TAG, status.getStatusMessage());
      } else if (resultCode == RESULT_CANCELED) {
        // The user canceled the operation.
      }
      //  super.onActivityResult(requestCode, resultCode, data);
    }
  }