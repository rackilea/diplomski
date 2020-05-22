private JTextField[][] fields = new JTextField[totalX][totalY];
... // create JTextField objects of the array

// then iterate on the array to add the Listener
for (JTextField field : fields){
    field.addFocusListener(new MyFocusListener());
}