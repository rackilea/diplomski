private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
int returnVal = fileChooser.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
    File file = fileChooser.getSelectedFile();
        try{

            FileInputStream mp3 = new FileInputStream(fileChooser.getSelectedFile());
            Player playMP3 = new Player(mp3);

            }catch(Exception e){System.out.println(e);

} }   
}