useLocation.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        SharedPreferences mPrefs = getSharedPreferences("Type", 0);
        activityType = mPrefs.getString("gosend", "0");

     //   SharedPreferences mPrefs1 = getSharedPreferences("Type1",0);
      //  goride = mPrefs1.getString("goride","0");

        switch (activityType){

            case "0":
                intent = new Intent(ChooseFromMapActivity.this, GoSend.class);
                startActivity(intent);
                break;
            case "1":
                intent = new Intent(ChooseFromMapActivity.this, GoRideActivity.class);
                startActivity(intent);
                break;
        }

    }
}