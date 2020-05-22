Function<Item, Item> fct2 = new Function<Item, Item>() {
    @Override
    public Item apply(Item item) {
        return item.doThis();
    }
};
entity.apply(fct);