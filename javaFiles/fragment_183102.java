double scale = 1;
    //scale only when component is wider then a page (page and component widths are doubles)
    if(componentWidth > pageWidth)
        scale = pageWidth/ componentWidth;
    //I first calculate where each page should end 
    //...
    //then when I paint a page I calculate translation over Y for each page
    double translateY = 0;
    //if page index grater then zero then take where the previous page ends
    if(pageIndex > 0)
        translateY = pageHeightEnds.get(pageIndex - 1);
    //shift Graphic to line up with beginning of next page to print
    g2.translate(0f, -translateY);

    g2.setClip(0, (int) Math.round(translateY),(int) Math.round(pageWidth), (int) Math.round(currentPageWidth));
    //  scale the page so the width fits...
    g2.scale(scala, scala);
    componentToPaint.paint(g2);