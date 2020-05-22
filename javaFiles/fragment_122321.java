public void show(List<Item> list) {
    for (Item item : list) {
        System.out.println(item.info());

        if(!item.getItemList().isEmpty()) {
            show(item.getItemList());
        }
    }
 }