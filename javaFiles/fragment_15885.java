public static boolean saveArray() {

    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

    SharedPreferences.Editor mEdit1 = sp.edit();


    mEdit1.putInt("Status_size", sKey.size());  

    for(int i=0;i<sKey.size();i++)  
    {
        mEdit1.remove("Status_" + i);
        mEdit1.putString("Status_" + i, sKey.get(i));  
    }

    return mEdit1.commit();     
}