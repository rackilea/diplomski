cdinventoryItem initem[] = new cdinventoryItem[DEFAULT_LENGTH];
// fill array
Arrays.sort(initem, 
  new Comparator<cdInventoryItem>() {
    public int compare(cdInventoryItem item1, cdInventoryItem item2) {
        return item1.getTitle().compareTo(item2.getTitle());
    }
  }
);