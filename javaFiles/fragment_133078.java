//Check if the image has been shown
SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
boolean first = sharedPref.getBoolean("first", true);
if(first){
    helpimg.setVisibility(View.VISIBLE);
    //Set the preference to false
    SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putBoolean("first", false);
    editor.commit();
}else{
    helpimg.setVisibility(View.GONE);
}