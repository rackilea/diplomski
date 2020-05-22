int pageCount = document.getDocumentCatalog().getAllPages().size();
for (int p = 0; p < pageCount; ++p)
{
    //... your options
    stripper.setStartPage(p);
    stripper.setEndPage(p);
    FileOutputStream fos = new FileOutputStream(new File(f5+(p+1)+".html"));
    stripper.writeText(document, fos);
    fos.close();
}