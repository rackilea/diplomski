public class A extends JPanel {

A() {
    this.setLayout(new FlowLayout());
    addProperties();
}

private void addProperties() {
    for (Field field : this.getClass().getDeclaredFields()) {
        Property prop = field.getAnnotation(Property.class);
        if (prop != null) {
            createAndAddComponents(prop);
        }
    }
}

private void createAndAddComponents(Property prop) {
    JLabel jLabel = new JLabel(prop.name());
    this.add(jLabel);
    switch (prop.type()) {
    case Textfield:
        JTextField jTextField = new JTextField();
        this.add(jTextField);
    case ...
        ...
    }
}
}