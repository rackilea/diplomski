private WordprocessingMLPackage getTemplate() throws Docx4JException, FileNotFoundException {
    WordprocessingMLPackage template = WordprocessingMLPackage.load(new java.io.File("G:\\WorkSpaces\\111.docx"));
    MainDocumentPart documentPart = template.getMainDocumentPart();

    List<Object> listObj = documentPart.getContent();

     String str = listObj.toString();
     System.out.println(str);

    return template;
}