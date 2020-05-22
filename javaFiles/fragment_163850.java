List<JTextField> textFields = new ArrayList<JTextField>();
...
//add your textfields to arraylist
...
for(int i = 0;i< textFields.size(); i++){
  fields[i] = textFields.get(i).getValue();
}