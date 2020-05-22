DocumentPanel clsDocumentPanel = new DocumentPanel(); // <- yes, here!
if(frmDocument == null){
    frmDocument = new JFrame(strName);
    frmDocument.setPreferredSize(new Dimension(600, 700));
    clsDocumentPanel.setDocument(strFileDirectory);
    frmDocument.add(clsDocumentPanel);
    frmDocument.pack();
    frmDocument.setVisible(true);
}else{
    if(!(frmDocument.getTitle().equals(strName))){
        frmDocument.setTitle(strName);
        clsDocumentPanel.setDocument(strFileDirectory);
        frmDocument.pack();
        frmDocument.setVisible(true);
    }
}