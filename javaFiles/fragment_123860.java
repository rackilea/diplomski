public void actionPerformed(ActionEvent evt) {

    LinkedFrame linkedFrame = new LinkedFrame(); // create the dialog, set as modal
    linkedFrame.setVisible(true); // code will block here till you close the dialog

    setSize(width, height); // supply the width & height you want
}