HashMap<String,ArrayList<Item>> bucketList = new HashMap();

for (Item i : listOfItems) {
    if(!bucketList.containsKey(i.getKey()) {
        bucketList.put(i.getKey(),new ArrayList());
    }

    buckList.get(i.getKey()).add(item);
}