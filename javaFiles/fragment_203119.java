TextField text =  new TextField("Edit");
Grid grid;
BeanItemContainer<Customer> container;

@Override
protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    container = new BeanItemContainer<>(Customer.class, Arrays.asList(new Customer("1"), new Customer("2")));
    grid = new Grid(container);
    Button open = new Button("open");
    open.addClickListener(this :: openListener);
    Button save = new Button("save");
    save.addClickListener(this :: saveListener);
    layout.addComponents(grid, open, save, text);
    setContent(layout);
}

private void openListener(Button.ClickEvent clickEvent){
    text.setValue(((Customer) (grid.getSelectedRow())).getName());
}
private void saveListener(Button.ClickEvent clickEvent){
    Customer c = (Customer) grid.getSelectedRow();
    c.setName(text.getValue());
    grid.clearSortOrder();
}