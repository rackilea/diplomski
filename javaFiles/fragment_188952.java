PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
@Override
public void onPlaceSelected(Place place) {
    // TODO: Get info about the selected place.
    Log.i(TAG, "Place: " + place.getName());
}

@Override
public void onError(Status status) {
    // TODO: Handle the error.
    Log.i(TAG, "An error occurred: " + status);
}
});