public List<Item> loadList(Context mContext)
{  
    Shared Preferences mSharedPreference1 = PreferenceManager.getDefaultSharedPreferences(mContext);
    List<Item> arrayList = new ArrayList<Item>();
    String arrayString = mSharedPreference1.getInt("list", "");  
    String array[] = arrayString.split(";");
    for(int i=0;i<array.length;i++) 
    {
        list.add(new Item(array[i]));
    }
    return list;

}