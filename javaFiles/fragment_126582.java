PDField field = acroForm.getField( "date" );
for (PDAnnotationWidget widget : field.getWidgets())
{
    PDPage page = widget.getPage();
    if (page == null)
    {
        // incorrect PDF. Plan B: try all pages to check the annotations.
        for (int p = 0; p < doc.getNumberOfPages(); ++p)
        {
            List<PDAnnotation> annotations = doc.getPage(p).getAnnotations();
            for (PDAnnotation ann : annotations)
            {
                if (ann.getCOSObject() == widget.getCOSObject())
                {
                    System.out.println("found at page: " + p);
                    break;
                }
            }
        }
        continue;
    }
    int pageNum = pdfDocument.getPages().indexOf(page);
    System.out.println("found at page: " + pageNum);
}