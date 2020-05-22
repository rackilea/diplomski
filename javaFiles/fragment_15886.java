public static void loadArray(Context mContext) {  




 SharedPreferences mSharedPreference1 =   PreferenceManager.getDefaultSharedPreferences(mContext);

    sKey.clear();

    int size = mSharedPreference1.getInt("Status_size", 0);  

    for(int i=0;i<size;i++) 
    {
     sKey.add(mSharedPreference1.getString("Status_" + i, null));
    }

}