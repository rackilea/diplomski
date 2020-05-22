DocxEditorKit DEK=new DocxEditorKit;
MetaphaseEditorPanel MEP=new MetaphaseEditorPanel;
MEP.getHTMLTextPane().setEditorKit(DEK);

   //Try and Catch blocks of course to read the file
DEK.read(new FileInputStream(PathToFile), MEP.getHTMLTextPane().getDocument(), 0);
getContentPane.add(MEP, BorderLayout.CENTER);