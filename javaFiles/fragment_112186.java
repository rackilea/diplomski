List list1=new ArrayList<String>();
    JSONArray array=jso.getJSONArray("UserData");
    for(int i=0;i<array.length();i++)
    {                                   list1.add(array.getJSONObject(i).getString("UserMobile"));

    }
   Iterator itr=list1.iterator();
     while(itr.hasNext())
    {
        str1=itr.next().e+"\n";

    }