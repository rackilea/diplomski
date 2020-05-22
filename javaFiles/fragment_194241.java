private TableView<Data> mainTable = new TableView<>() {

    @Override
    protected Skin<?> createDefaultSkin() {
        return new TweakedTableSkin<>(this);
    }

};