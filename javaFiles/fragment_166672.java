List<Item> myList = new ArrayList<Item>();
    for (Item item: filter.getFilter()) {
        MyItem myItem = new MyItem(item);
        myList.add();
    }
    this.filter.setFilter(myList);