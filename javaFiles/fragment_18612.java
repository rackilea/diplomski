JPanel grid = new JPanel( new GridLayout(0, 2) );

for(i = 0; i < count; i++) 
{
    JTextField textField = new JTextField(10);
    textField.setText( Integer.toString(i) );
    nameInputs[i] = textField();
    grid.add( textField ):
}

frame.add(grid);
frame.pack();
frame.setVisible( true );