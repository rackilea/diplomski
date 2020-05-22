String[] data = {"one", "two", "three", "four"};
DefaultListModel<String> add = new DefaultListModel<String>();

for (String str : data)
     add.addElement(str);

JList<String> myList = new JList<String>(add);

final String find = "Two";
for (int x = 0; x < myList.getModel().getSize(); x++) {
 if (myList.getModel().getElementAt(x).compareToIgnoreCase(find) == 0) {
     System.out.println("Found at index " + x);
     DefaultListModel<String> model = (DefaultListModel<String>)myList.getModel();
     model.remove(x);
 }
}