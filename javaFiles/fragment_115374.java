ArrayList<DataObject> list;
onCreate() {
 list=new ArrayList(); 
 ListAdapter dataListAdapter =new ListAdapter(list) // creating an adapter with empty list of data
 listView.setAdpater(adpater);
}