table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
    @Override
    public void itemClick(ItemClickEvent itemClickEvent) {
        System.out.println(itemClickEvent.getItemId().toString());
    }
});