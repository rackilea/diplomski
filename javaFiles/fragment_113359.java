public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
    Graphics2D g2d = (Graphics2D) g;

    double x1 = pf.getImageableX();
    double y1 = pf.getImageableY();
    double x2 = pf.getImageableWidth();
    double y2 = pf.getImageableHeight();    

    g2d.drawString( "Page #" + pageIndex, (int)((x2-x1)/2+x1), (int)((y2-y1)/2+y1) );

    return (PAGE_EXISTS);
}