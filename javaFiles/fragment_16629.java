public class B extends A {
    @Property(name = "Cities",  type = PropertyType.Textfield, description = "Number of cities")
    private int cities;
    @Property(name = "Cool Cities",  type = PropertyType.Textfield, description = "Number of cool cities")
    private int coolCities;

    public static void main(String[] args) {
        final B b = new B();
        b.addPropertyChangeListener("cities", new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("Cities: " + b.cities);
            }

        });
        b.addPropertyChangeListener("coolCities", new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("Cool Cities: " + b.coolCities);
            }

        });

        JFrame frame = new JFrame();
        frame.add(b);
        frame.setVisible(true);
    }
}


public class A extends JPanel {

    //Need this retention policy, otherwise the annotations aren't available at runtime:
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Property {
        String name();
        PropertyType type();
        String description();
    }

    public enum PropertyType {
        Textfield
    }


    A() {
        addProperties();
    }

    private void addProperties() {
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        Group column1 = layout.createParallelGroup();
        Group column2 = layout.createParallelGroup();
        Group vertical = layout.createSequentialGroup();

        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true); // only needed for setting the value.
            Property prop = field.getAnnotation(Property.class);
            if (prop != null) {
                Group row = layout.createParallelGroup();

                createAndAddComponents( prop, column1, column2, row, field );
                vertical.addGroup(row);
            }
        }
        Group horizontal = layout.createSequentialGroup();
        horizontal.addGroup(column1);
        horizontal.addGroup(column2);
        layout.setHorizontalGroup(horizontal);
        layout.setVerticalGroup(vertical);
    }

    private void createAndAddComponents(Property prop, Group column1, Group column2, Group vertical, final Field field) {
        JLabel jLabel = new JLabel(prop.name() + " (" + prop.description() + ")");
        column1.addComponent(jLabel);
        vertical.addComponent(jLabel);
        switch (prop.type()) {
        case Textfield:
            final JTextField jTextField = new JTextField();
            jTextField.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateValue();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateValue();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateValue();
                }

                private void updateValue() {
                    try {
                        int value = Integer.parseInt(jTextField.getText());
                        field.setInt(A.this, value);
                        firePropertyChange(field.getName(), "figure out old", value);
                    } catch (NumberFormatException e1) {
                    } catch (IllegalArgumentException e1) {
                    } catch (IllegalAccessException e1) {
                    }
                }

            });
            column2.addComponent(jTextField);
            vertical.addComponent(jTextField, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE);
        }
    }
}