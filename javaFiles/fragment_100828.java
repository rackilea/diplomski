@Override
public void onItemClick(AdapterView<?> adapter, View arg1, int arg2, long arg3)
{

       SparseBooleanArray sp=getListView().getCheckedItemPositions();

     String str="";
       for(int i=0;i<sp.size();i++)
       {
           str+=movies.get(sp.keyAt(i))+",";
        }
      Toast.makeText(this, ""+str, Toast.LENGTH_SHORT).show();

 }