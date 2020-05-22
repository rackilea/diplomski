String[] items;
final ArrayList<String>tempListItems;
{
    tempListItems= new ArrayList<>();
}

public void initList() {
    if(query()){
        items = new String[tempListItems.size()];
        items = tempListItems.toArray(items);
        Arrays.sort(items);

        Log.d("HSearch - initList", "Generate Clean List");
        Log.d("initList - temp size", Integer.toString(tempListItems.size()));
        Log.d("initList - items size", Integer.toString(items.length));
    }
}

private boolean query() {
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Table");
    query.orderByAscending("name");
    query.findInBackground(new FindCallback<ParseObject>() {
        @Override
        public void done(List<ParseObject> list, com.parse.ParseException e) {
            if (e == null) {
                for (ParseObject name : list) {
                    tempListItems.add(name.getString("name"));
                }
            } else {
                Log.d("score", "Error: " + e.getMessage());
            }
        }
    });
    return true;
}