public boolean saveList(List<Item> list)
    {
        SharedPreferences sp = SharedPreferences.getDefaultSharedPreferences(this);
        SharedPreferences.Editor mEdit1 = sp.edit();
        mEdit1.remove("list"); // be sure that there was no item like that
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<list.size();i++)  
        {
            stringBuffer.append(list.get(i));
            stringBuffer.append(";");
        }
        mEdit1.putString("list",stringBuffer.toString());
        return mEdit1.commit();     
    }