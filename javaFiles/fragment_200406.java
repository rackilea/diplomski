inventoryItems = new ArrayList<String>();
arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, inventoryItems);

final View rootView = inflater.inflate(R.layout.fragment_inventory_display, container, false);
final ListView productsList = (ListView) rootView.findViewById(R.id.itemlistView);

ParseQuery<ParseObject> query = ParseQuery.getQuery("Inventory");
query.findInBackground(new FindCallback<ParseObject>() {
    @Override
    public void done(List<ParseObject> stockItemList, ParseException e) {
        if(e == null){
            if(stockItemList.size() > 0){



                for(ParseObject unit : stockItemList){

                inventoryItems.add(unit.get("productName").toString());
                    Log.d("unit", "retrieved: " + stockItemList.size());

                }


                productsList.setAdapter(arrayAdapter);

            }

        } else {

            Log.d("unit", "Error: " + e.getMessage());
        }
    }
});


// Inflate the layout for this fragment
return rootview;