public class MyUi extends UI {
    @Override
    protected void init(VaadinRequest request) {
        // basic stuff
        Layout content = new VerticalLayout();
        content.setSizeFull();
        setContent(content);

        // container & grid
        BeanItemContainer<Address> container = new BeanItemContainer<>(Address.class);
        Grid grid = new Grid(container);

        // 1) either manually add nested properties and hide the actual inner bean
        container.addNestedContainerProperty("city.name");
        grid.getColumn("city.name").setHeaderCaption("City");
        grid.setColumns("street", "city.name"); // hide bean column

        // 2) or make the container create nested properties for your inner beans
        container.addNestedContainerBean("city");
        grid.getColumn("city.name").setHeaderCaption("City");

        // create some dummy data to populate the grid
        City city = new City("There");
        Address address = new Address(city, "Here");
        container.addItem(address);
        content.addComponent(grid);
    }
}