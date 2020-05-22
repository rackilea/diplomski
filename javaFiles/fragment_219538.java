// You have to figure out formLabels list
// The same column identifiers in your table maybe?

FormGenerator formGenerator = new FormGenerator(formLabels);                
JPanel formPanel = formGenerator.getPanel();

int option = JOptionPane.showConfirmDialog(null
                                         , formPanel
                                         ,"Add item"
                                         , JOptionPane.OK_CANCEL_OPTION
                                         , JOptionPane.PLAIN_MESSAGE);

if (option == JOptionPane.OK_OPTION) {
    Map<String, String> data = formGenerator.getDataFromTextFields();
    for (String key : data.keySet()) {
        System.out.println(String.format("%1s : %2s", key, data.get(key)));
    }
}