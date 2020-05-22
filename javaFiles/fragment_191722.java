/**
 * On click listener for the add button
 */
addButton.addActionListener(new ActionListener() {
    String nl = "\n",
        data = "";
    public void actionPerformed(ActionEvent ae){
        data += "Label: " + albumLabel.getText() + nl;
        data += "Artist: " + albumArtist.getText() + nl;
        /*
         * Repeat the same for any other text fields you have
         */
        dataWriter(data, "test.txt");

    } 
 });