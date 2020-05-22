public class ComboBoxComponent extends VerticalLayout {
    public ComboBoxComponent() {
        BeanItemContainer<Person> dataSource = new BeanItemContainer<>(HasCaption.class);

        ComboBox comboBox = new ComboBox();
        comboBox.setItemCaptionMode(AbstractSelect.ItemCaptionMode.PROPERTY);

        // use a fake property which will get identified by the getter
        comboBox.setItemCaptionPropertyId("caption");
        addComponent(comboBox);

        comboBox.setContainerDataSource(dataSource);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            dataSource.addBean(new Person("Name " + i, "Surname " + i, random.nextInt(99) + 1));
        }
    }
}