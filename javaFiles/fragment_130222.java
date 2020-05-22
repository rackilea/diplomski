public class TestReport implements Printable
{
    //Here is where we set up the class variables.
    private int numberOfPages = 0;              //numberOfPages -- How many pages we will be printing.
    private int headerLines = 0;                //headerLines -- How many lines are in the header.
    private int footerLines = 0;                //footerLines -- How many lines are in the footer.
    private int bodyLines = 0;                  //bodyLines -- How many lines we've added to the body of the report.
    private boolean useDefaultFooter = false;   //useDefaultFooter -- If we are to use the default footer instead of a custom one.
    private int fontSize = 10;                  //fontSize -- The size of the font to use, in points. The default is 10pt.
    private Vector header = new Vector();       //header -- The vector containing the header text.
                                                //Each item in the vector is a line on the header.
    private Vector body = new Vector();         //body -- The vector containing the body text.
    private Vector footer = new Vector();       //footer -- The vector containing the footer.

    //The constructor does not need to do anything.

    /**
     * Create a new instance or TestReport
     */
    public TestReport() 
    {

    }

    /**
     * Prints the final report after the information has been added.
     */
    public void printReport()
    {

        //Get the number of lines in the header, body, and footer. If we're using the default footer, it's only one line long.

        headerLines = header.size();
        bodyLines = body.size();
        if (useDefaultFooter == true) {
            footerLines = 1;
        } else {
            footerLines = footer.size();
        }
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        PageFormat landscape = printerJob.defaultPage();
        landscape.setOrientation(PageFormat.LANDSCAPE);
        printerJob.setPrintable(TestReport.this, landscape);

        printerJob.printDialog();

        try {
            printerJob.print();
        } catch (Exception PrintException) {}
    }

    public void addHeaderLine (String headerLine)
    {
        header.addElement(headerLine);
    }

    public void addBodyLine (String bodyLine)
    {
        body.addElement(bodyLine);
    }

    public void addFooterLine (String footerLine)
    {
        footer.addElement(footerLine);
    }

    public void setFontSize(int fontSize)
    {
        this.fontSize = fontSize;
    }

    public void useDefaultFooter()
    {
        useDefaultFooter = true;
    } 


    public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException 
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        Font myFont = new Font("Courier", Font.PLAIN, fontSize);
        g2.setFont(myFont);

        int fontHeight = g2.getFontMetrics().getHeight();
        int fontDescent = g2.getFontMetrics().getDescent();

        double pageHeight = pageFormat.getHeight();
        double pageWidth = pageFormat.getWidth();

        int lineHeight = fontHeight + fontDescent;

        int linesPerPage = (int)((pageHeight - 72 - 72) / lineHeight);

        int bodyLinesPerPage = linesPerPage - headerLines - footerLines;

        int numberOfPages = (int)Math.ceil((double)bodyLines / bodyLinesPerPage);

        if (pageIndex >= numberOfPages)
        {
            return Printable.NO_SUCH_PAGE;
        }
        //Start at one inch down, one inch accross
        int currentY = 72 + lineHeight;
        int currentX = 72;

        //Draw the header
        for (int i = 0; i < header.size(); i++) 
        {
            g2.drawString(header.get(i), currentX, currentY);
            currentY = currentY + lineHeight;
        }
        //Draw the body
        for (int i = bodyLinesPerPage * pageIndex; i < (bodyLinesPerPage * (pageIndex + 1)) ; i++ )
        {
            if (i < body.size()){
                g2.drawString(body.get(i), currentX, currentY);
            }
            currentY = currentY + lineHeight;
        }
        if (useDefaultFooter == true) 
        {
            GregorianCalendar calendar = new GregorianCalendar();
            int todayYear = calendar.get(GregorianCalendar.YEAR);
            int todayMonth = calendar.get(GregorianCalendar.MONTH) + 1;
            int todayDay = calendar.get(GregorianCalendar.DAY_OF_MONTH); 

            String theMonth = "0" + todayMonth;
            String theDay   = "0" + todayDay;

            g2.drawString("SYSTEM DATE: " + todayYear + "-" + theMonth.substring
                          (theMonth.length() - 2) + "-" + 
                          theDay.substring(theDay.length() - 2) 
                          + " | PAGE " + (pageIndex + 1) 
                          + " OF " + numberOfPages, currentX, currentY);
        } 
        else 
        {
            for (int i = 0; i < footer.size(); i++)
            {
                g2.drawString(footer.get(i), currentX, currentY);
                currentY = currentY + lineHeight;
            }
        }
        return Printable.PAGE_EXISTS;       
    }
}