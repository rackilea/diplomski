List<JCheckBox> checkboxes = new ArrayList<JCheckBox>(); 
//changed CheckBox to JCheckBox above
String labels[] = {"A", "B", "C", "D", "E", "F"}; 
for (int i = 0; i < labels.length; i++) { 
   JCheckBox checkbox = new JCheckBox(labels[i]); 
   //Declared and initialised JCheckBox instead of CheckBox
   checkboxes.add(checkbox); 
   //for further use you add it to the list 
}