SharedPreferences sharedPreferences = 
getActivity().getSharedPreferences("key", 0);
SharedPreferences.Editor editor = sharedPreferences.edit();
editor.putBoolean("**switchValue**", aSwitch.isChecked());
editor.apply();
boolean showNotifications = 
editor.getBoolean("**switchValue**",false);