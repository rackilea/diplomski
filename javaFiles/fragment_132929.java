public class CustomTablePrintable implements Printable {

    Printable tablePrintable;
    JTable table;
    MessageFormat header; 
    MessageFormat footer;

    public CustomTablePrintable(MessageFormat header, MessageFormat footer) {
        this.header = header;
        this.footer = footer;
    }

    public void setTablePrintable(JTable table, Printable printable) {
        tablePrintable = printable;        
        this.table = table;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, 
            int pageIndex) throws PrinterException {
        // grab an untainted graphics
        Graphics2D g2d = (Graphics2D)graphics.create();
        // calculate the offsets and wrap the pageFormat
        double headerOffset = calculateHeaderHeight(g2d, pageIndex);
        CustomPageFormat wrappingPageFormat = new CustomPageFormat(pageFormat, headerOffset, 0);
        // feed the wrapped pageFormat into the default printable
        int exists = tablePrintable.print(graphics, wrappingPageFormat, pageIndex);
        if (exists != PAGE_EXISTS) {
            g2d.dispose();
            return exists;
        }
        // translate the graphics to the start of the original pageFormat and draw header
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        printHeader(g2d, pageIndex, (int) pageFormat.getImageableWidth());
        g2d.dispose();

        return PAGE_EXISTS;        
    }


    protected double calculateHeaderHeight(Graphics2D g, int pageIndex) {
        if (header == null) return 0;
        Object[] pageNumber = new Object[]{new Integer(pageIndex + 1)};
        String text = header.format(pageNumber);
        Font headerFont = table.getFont().deriveFont(Font.BOLD, 18f);
        g.setFont(headerFont);
        Rectangle2D rect = g.getFontMetrics().getStringBounds(text, g);
        return rect.getHeight();
    }

    protected void printHeader(Graphics2D g, int pageIndex, int imgWidth) {
        Object[] pageNumber = new Object[]{new Integer(pageIndex + 1)};
        String text = header.format(pageNumber);
        Font headerFont = table.getFont().deriveFont(Font.BOLD, 18f);
        g.setFont(headerFont);
        Rectangle2D rect = g.getFontMetrics().getStringBounds(text, g);
        // following is c&p from TablePrintable printText
        int tx;

        // if the text is small enough to fit, center it
        if (rect.getWidth() < imgWidth) {
            tx = (int) ((imgWidth - rect.getWidth()) / 2);

            // otherwise, if the table is LTR, ensure the left side of
            // the text shows; the right can be clipped
        } else if (table.getComponentOrientation().isLeftToRight()) {
            tx = 0;

            // otherwise, ensure the right side of the text shows
        } else {
            tx = -(int) (Math.ceil(rect.getWidth()) - imgWidth);
        }

        int ty = (int) Math.ceil(Math.abs(rect.getY()));
        g.setColor(Color.BLACK);
        g.drawString(text, tx, ty);

    }
}