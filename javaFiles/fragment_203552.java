ArrayList<String> aList = new ArrayList<String>();
aList.add("blabla");
aList.add("blublu");
aList.add("blibli");
aList.add("bleble");
DefaultListModel<String> model = new DefaultListModel<String>();
for(String s:aList){
model.addElement(s);
}
JList<String> contactList = new JList<String>(model);