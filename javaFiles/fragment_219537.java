public class FormGenerator {

    private Map<String, String> data;
    private JPanel panel;

    public FormGenerator(List<String> formLabels) {
        super();
        initMap(formLabels);
        initPanel(formLabels);
    }

    private void initMap(List<String> formLabels) {
        data = new HashMap();
        for (String label : formLabels) {
            data.put(label, "");
        }
    }

    private void initPanel(List<String> formLabels) {
        int numberOfFields = formLabels.size();
        panel = new JPanel(new GridLayout(numberOfFields, 2, 6, 6));

        for (String fieldLabel : formLabels) {
            JLabel label = new JLabel(fieldLabel);
            label.setHorizontalAlignment(JLabel.TRAILING);
            panel.add(label);

            JTextField textField = new JTextField(15);
            textField.putClientProperty("Textfield.For.Field", fieldLabel);
            panel.add(textField);
        }
    }

    public Map<String, String> getDataFromTextFields() {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JTextField) {
                JTextField textField = (JTextField)comp;
                String key = (String)textField.getClientProperty("Textfield.For.Field");
                String value = textField.getText().trim();
                data.put(key, value);
            }
        }
        return data;
    }


    public JPanel getPanel() {
        return panel;
    }
}