private JFileChooser chooser;
//...
protected JFileChooser getFileChooser() {
    if (chooser == null) {
        chooser = new JFileChooser(...);
        FileFilter docx = new FileNameExtensionFilter("MS Word file(.docx)", "docx");
        FileFilter doc = new FileNameExtensionFilter("MS Word file(.doc)", "doc");
        FileFilter pdf = new FileNameExtensionFilter("Pdf file(.pdf)", "pdf");
        chooser.addChoosableFileFilter(docx);
        chooser.addChoosableFileFilter(doc);
        chooser.addChoosableFileFilter(pdf);
        chooser.setFileFilter(docx);
        chooser.setAcceptAllFileFilterUsed(false);
    }
    return chooser;
}
//...
public void actionPerformed(ActionEvent evt) {
    JFileChooser chooser = getFileChooser();
    int ret = chooser.showOpenDialog(chooserFrame);
    if(ret == JFileChooser.APPROVE_OPTION){
        try{
            File leftFile = chooser.getSelectedFile();
            leftfileName =  leftFile.getName().toLowerCase();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}