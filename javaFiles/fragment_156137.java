sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
       String name=sharedpreferences.getString("show_ads", "yes");
    if(name.equals("yes")){
         adLayout.setEnabled(true);
        adLayout.setVisibility(View.VISIBLE);

        disableAds.setEnabled(true);
        disableAds.setVisibility(View.VISIBLE);
      }else{
         adLayout.setEnabled(false);
        adLayout.setVisibility(View.GONE);

        disableAds.setEnabled(false);
        disableAds.setVisibility(View.GONE);
     }