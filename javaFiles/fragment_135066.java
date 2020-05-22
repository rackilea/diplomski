DefaultListModel list = new DefaultListModel();
String[] items = jTextArea2.getText().split("\n");

for(String item : items) {
    list.addElement(item);
}

jList1.setModel(list);