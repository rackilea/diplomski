public class CustomPageFormat extends PageFormat {

    private PageFormat delegate;
    private double headerHeight;
    private double footerHeight;

    public CustomPageFormat(PageFormat format, double headerHeight, double footerHeight) {
        this.delegate = format;
        this.headerHeight = headerHeight;
        this.footerHeight = footerHeight;
    }
    /** 
     * @inherited <p>
     */
    @Override
    public double getImageableY() {
        return delegate.getImageableY() + headerHeight;
    }

    /** 
     * @inherited <p>
     */
    @Override
    public double getImageableHeight() {
        return delegate.getImageableHeight() - headerHeight - footerHeight;
    }

    // all other methods simply delegate