protected void initDataBindings() {
    BeanProperty<Apprentice, String> apprenticeBeanProperty_1 = BeanProperty.create("vorname");
    BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
    AutoBinding<Apprentice, String, JTextField, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, apprentice, apprenticeBeanProperty_1, txtVorname, jTextFieldBeanProperty_1);
    autoBinding_1.bind();
}