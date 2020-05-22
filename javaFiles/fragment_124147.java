public void refreshlist(){
    mymap = null;

    mymap = providerTester.downLoadinfo(value1,value2);
    list_my = new ArrayList<String>(mymap.keySet());    
    adapter = new ArrayAdapter<String>(ClassName.this,android.R.layout.simple_list_item_multiple_choice, list_my);
  //using builtin list_item
   getListView().setChoiceMode(2);

   setListAdapter(adapter); 
}