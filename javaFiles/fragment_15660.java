public class ComboBoxComponent extends VerticalLayout {
    public ComboBoxComponent() {
        BeanItemContainer<Person> dataSource = new BeanItemContainer<>(Person.class);

        addComponent(new MyComboBox<>(new PersonCaptionGenerator(), dataSource));

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            dataSource.addBean(new Person("Name " + i, "Surname " + i, random.nextInt(99) + 1));
        }
    }
}