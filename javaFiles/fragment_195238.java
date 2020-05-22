final Table table = new Table();
table.setEditable(true);
table.setTableFieldFactory(new TableFieldFactory() {
    private static final long serialVersionUID = 1L;

    @Override
    public Field<?> createField(Container container, Object itemId, Object propertyId, Component uiContext) {
        if (itemId == table.getData()) {
            return DefaultFieldFactory.get().createField(container, itemId, propertyId, uiContext);
        }
        return null;
    }
});
table.addGeneratedColumn("", new ColumnGenerator() {
    private static final long serialVersionUID = 1L;

    @Override
    public Object generateCell(Table source, final Object itemId, Object columnId) {
        Button button = new Button(itemId == table.getData() ? "Save" : "Edit");
        button.addClickListener(new ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(ClickEvent event) {
                if (table.getData() == null) {
                    // edit
                    table.setData(itemId);
                    table.refreshRowCache();
                } else if (itemId == table.getData()) {
                    // save
                    table.setData(null);
                    // ...
                    table.refreshRowCache();
                }
            }
        });
        return button;
    }
});
// ...