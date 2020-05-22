ButtonModel model = sizeButtonGroup.getSelection(); 
String size = model == null ? "Small" : model.getActionCommand();

pst.setString(4, size);

// Repeat for other groups/columns