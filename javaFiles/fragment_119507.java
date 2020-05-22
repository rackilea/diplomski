int returnVal = fc.showOpenDialog();
if(returnVal == JFileChooser.APPROVE_OPTION) {
   System.out.println("You chose to open this file: " +
        fc.getSelectedFile().getName());
}
else {
    // handle non-selection here
}