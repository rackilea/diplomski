private void onPrint()
{
    try
    {
        Object o = mStatisticSelectorBox.getSelectedItem();
        if(o == null)
            return;

        IStatisticGraph gr = (IStatisticGraph)o;
        StatisticPage page = gr.getPage();
        if(page == null)
            return;

        PrinterJob prt = PrinterJob.getPrinterJob();

        PageFormat pf0 = prt.defaultPage();
        PageFormat pf1;
        pf0.setOrientation(PageFormat.LANDSCAPE);
        pf1 = prt.pageDialog(pf0);
        if(pf1.equals(pf0) == true)
            return;

        Book book = new Book();
        book.append(page, pf1);
        prt.setPageable(book);

        try
        {
            prt.print();
        }
        catch (PrinterException exception)
        {
        }
    }
    catch(Throwable e)
    {
        showError(e.getClass().getCanonicalName(), e.getLocalizedMessage(), e);
    }
}