public class TestPane extends JPanel {

    private Map<DocumentFilter, JTextField> fields;

    public TestPane() {

        fields = new HashMap<>(25);
        ValidationListener listener = new ValidationListener() {

            @Override
            public void validationFailed(DocumentFilter filter) {
                JTextField field = fields.get(filter);
                if (field != null) {
                    field.setBackground(Color.RED);
                }
            }

            @Override
            public void validationPassed(DocumentFilter filter) {
                JTextField field = fields.get(filter);
                if (field != null) {
                    field.setBackground(UIManager.getColor("TextField.background"));
                }
            }
        };

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        for (int index = 0; index < 10; index++) {
            JTextField field = new JTextField(10);
            IntFilter filter = new IntFilter();
            filter.setValidationListener(listener);
            ((AbstractDocument) field.getDocument()).setDocumentFilter(filter);
            fields.put(filter, field);
            add(field, gbc);
        }

    }

}