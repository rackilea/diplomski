String[] data = {"one", "two", "three", "four"};
JList<String> myList = new JList<String>(data);

final String find = "Two";
for (int x = 0; x < myList.getModel().getSize(); x++) {
 if (myList.getModel().getElementAt(x).compareToIgnoreCase(find) == 0) {
     System.out.println("Found at index " + x);
 }
}