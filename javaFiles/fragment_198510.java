class EditHandler implements ActionListener{
    ...
    public void actionPerformed(ActionEvent ae){
        ...
        notepad.add(find_field);
        notepad.add(find);        
        notepad.validate();  // forces the Frame to refresh with new Elements