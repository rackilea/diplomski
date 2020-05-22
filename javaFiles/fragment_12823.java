for( PDPage page : doc.getPages() )
{
    pageNum++;
    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
    List<PDAnnotation> annotations = page.getAnnotations();
    //first setup text extraction regions
    for( int j=0; j<annotations.size(); j++ )
    {
        PDAnnotation annot = annotations.get(j);
        if( annot instanceof PDAnnotationLink )
        {
            PDAnnotationLink link = (PDAnnotationLink)annot;
            PDRectangle rect = link.getRectangle();
            //need to reposition link rectangle to match text space
            float x = rect.getLowerLeftX();
            float y = rect.getUpperRightY();
            float width = rect.getWidth();
            float height = rect.getHeight();
            int rotation = page.getRotation();
            if( rotation == 0 )
            {
                PDRectangle pageSize = page.getMediaBox();
                y = pageSize.getHeight() - y;
            }
            else if( rotation == 90 )
            {
                //do nothing
            }

            Rectangle2D.Float awtRect = new Rectangle2D.Float( x,y,width,height );
            stripper.addRegion( "" + j, awtRect );
        }
    }

    stripper.extractRegions( page );

    for( int j=0; j<annotations.size(); j++ )
    {
        PDAnnotation annot = annotations.get(j);
        if( annot instanceof PDAnnotationLink )
        {
            PDAnnotationLink link = (PDAnnotationLink)annot;
            PDAction action = link.getAction();
            String urlText = stripper.getTextForRegion( "" + j );
            if( action instanceof PDActionURI )
            {
                PDActionURI uri = (PDActionURI)action;
                System.out.println( "Page " + pageNum +":'" + urlText.trim() + "'=" + uri.getURI() );
            }
        }
    }
}