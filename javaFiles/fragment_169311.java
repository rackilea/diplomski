public class StatisticPage
    implements Printable
{
    private ChartPanel mChart = null;

    public StatisticPage(ChartPanel oChart)
    {
        mChart = oChart; 
    }

    public int print(Graphics g, PageFormat format, int pageIndex)
    {
        if(mChart == null)
            return Printable.NO_SUCH_PAGE;

        return mChart.print(g, format, pageIndex);
    }
}