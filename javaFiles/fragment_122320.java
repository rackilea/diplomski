public void show(List<Item> list) {
    for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i).info());

        if (!list.get(i).getItemList().isEmpty()) {
            show(list.get(i).getItemList());
        }
    }
}