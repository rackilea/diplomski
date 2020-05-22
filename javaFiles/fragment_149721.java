SharedPreferences mySharedPrefs = getSharedPreferences("MyPreferences", 0);
                if(mySharedPrefs.contains("theKey")) {
SharedPreferences.Editor editor = settings.edit();
                editor.remove("thekey");
                editor.commit();
}