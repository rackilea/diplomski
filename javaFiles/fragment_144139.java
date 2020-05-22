ArrayList<HashMap<String, String>> LIST3;
@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    LIST3 = new ArrayList<HashMap<String, String>>();

}

LISTMENU.setOnItemClickListener(new OnItemClickListener() 
{
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
    {

        HashMap<String, String> map = LIST2.get(position);

        itemValue = map.get(FOODNAME2);
        itemID = map.get(FOODID2);

        Toast.makeText(getApplicationContext(),
                "Food ID : " + itemID + "ListItem : " + itemValue , Toast.LENGTH_LONG)
                .show();

        listOrder(itemValue, itemID);
     }
});