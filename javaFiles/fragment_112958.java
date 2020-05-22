ArrayList<String> itemList = new ArrayList<String>();

for(int i=0; i<simpleAdapter.getCount();i++ ){
    String item = simpleAdapter.getItem(i).toString();
    item = item.replace("{","").replace("}","").replace("=","").trim();
    itemList.add(item);
}
String[] itemArr = new String[itemList.size()];
itemArr = itemList.toArray(itemArr);
multiSelectionSpinner.setItems(itemArr);