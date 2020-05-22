JTextField textField = new JTextField();
textField.setText("Remi");

Vector v = new Vector();
v.add("Jimmy");
v.add("Julie");
v.add("Julien");
v.add("Juliette");

JList list = new JList(v);
Configurator.enableAutoCompletion(list, textField);