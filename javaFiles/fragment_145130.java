private final PDDocument doc = new PDDocument();
private final PDEmbeddedFilesNameTreeNode efTree = new PDEmbeddedFilesNameTreeNode();
private final PDDocumentNameDictionary names = new PDDocumentNameDictionary(doc.getDocumentCatalog());
private final Map<String, PDComplexFileSpecification> efMap = new HashMap<>();

public void addFile(PDDocument doc, File child) throws IOException {
    File file = new File(child.getPath());

    Calendar date = Calendar.getInstance();

    //first create the file specification, which holds the embedded file
    PDComplexFileSpecification fs = new PDComplexFileSpecification();
    fs.setFileUnicode(child.getName());
    fs.setFile(child.getName());
    InputStream is = new FileInputStream(file);
    PDEmbeddedFile ef = new PDEmbeddedFile(doc, is);

    //Setting
    ef.setSubtype("application/octet-stream");
    ef.setSize((int) file.length() + 1);
    ef.setCreationDate(date);
    ef.setModDate(date);
    COSDictionary dictionary = fs.getCOSObject();
    dictionary.setItem(COSName.getPDFName("AFRelationship"), COSName.getPDFName("Data"));

    fs.setEmbeddedFile(ef);

    efMap.put(child.getName(), fs);
    efTree.setNames(efMap);

    names.setEmbeddedFiles(efTree);
    doc.getDocumentCatalog().setNames(names);
    is.close();
}