@Override
public void onResume(){
 super.onResume();
 HashMap<String, String> user = userPreference.getWorkDetails();
    boolean sports = user.get(userPreference.isSportsCheck);
    boolean tech = user.get(userPreference.isTechnologyCheck);

    if(sports){
          sports_layout.setVisibility(View.VISIBLE);
          load_sports_data();
       ..........