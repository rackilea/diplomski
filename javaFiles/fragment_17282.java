PDDocument a1doc = PDDocument.load(file1);
    PDDocument b1doc = PDDocument.load(file2);
    PDDocument resDoc = new PDDocument();

    List<PDPage> a1Pages = a1doc.getDocumentCatalog().getAllPages();
    List<PDPage> b1Pages = b1doc.getDocumentCatalog().getAllPages();

    // replace the 3rd page of the 2nd file with the 1st page of the 1st one
    for (int p = 0; p < b1Pages.size(); ++p)
    {
        if (p == 2)
            resDoc.addPage(a1Pages.get(0));
        else
            resDoc.addPage(b1Pages.get(p));
    }

    resDoc.save(file3);
    a1doc.close();
    b1doc.close();
    resDoc.close();