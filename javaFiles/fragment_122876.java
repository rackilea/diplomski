@Override
public void onSaveInstanceState(@NonNull Bundle outState) {
    Log.d("testing" , "On save instancestate") ;
    super.onSaveInstanceState(outState);

    SharedPreferences preferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
    preferences.edit()
        .putString("selectedCity", selectedCity)
        .putString("selectedTheater", selectedTheater)
    .commit();
}