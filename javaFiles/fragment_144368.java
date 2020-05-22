//ArrayList<ArrayList<Item>> items;
//int columnHeight;
for( ArrayList<Item> arr : items )
  Collections.sort(arr, new Comparator<Item>() {
    @Override
    public int compare(Item i1, Item i2) {
        return ...; // place the sorting rule here
    }
  });