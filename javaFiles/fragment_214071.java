JButton saveFile = new JButton("Save"); // Put text into the button!

public NewFileBox(){
    saveFile.addActionListener(this);
}

final JComponent[] inputs = new JComponent[]{
        new JLabel("Project Name"),
        projectName,
        // new JButton("Save")  // Get rid of this!
        saveFile  // add this!
};