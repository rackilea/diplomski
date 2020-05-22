for(int i=0;i<len;i++)
{
Map store=new HashMap();
    cid[i]=json.getJSONArray("Children").getJSONObject(i).getJSONObject("Child").get("childID").toString();
    name[i]=json.getJSONArray("Children").getJSONObject(i).getJSONObject("Child").get("childName").toString();
    store.put("ID", cid[i]);
    store.put("Names",name[i]);
Children.add(store);

}

System.out.println(Children);