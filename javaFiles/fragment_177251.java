public class Graph extends Activity{

    LinearLayout linearlayout;

    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

            linearlayout = (LinearLayout) View.inflate(this, R.layout.linearlayoutgraph, null);
            ContentValues datasetDescription = new ContentValues();
            //add your graph
            xyLineChart mView = new xyLineChart(this, datasetDescription, createDataset());
            linearlayout.addView(mView);
            setContentView(linearlayout);
    }

//create data
private XYDataset createDataset()
{
}