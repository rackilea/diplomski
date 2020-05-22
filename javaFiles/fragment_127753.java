public static void setPreference(Context context, String preferenceName)
{
    SharedPreferences settings = context.getSharedPreferences(preferenceName, 0);
    SharedPreferences.Editor editor = settings.edit();
    //Add a key to this preference and his value.
    editor.putString(preferenceName+"_value", "Value stored in preference called: " + preferenceName);
    editor.commit();
}