public class Plot_Activity extends AppCompatActivity {      
String valXY[];
Double Xval;
Double Yval;
GraphView graph;
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
GraphView graph = (GraphView) findViewById(R.id.graph);

 BufferedReader reader = null;
try {
      reader = new BufferedReader(new InputStreamReader(getAssets().open("plot/excel_data_abp.csv")));
            reader.readLine();  //skip first line of file
            reader.readLine();  //skip second line of file
            String mline;

            ArrayList<DataPoint> arrDataPoint=new ArrayList<>();
            while ((mline = reader.readLine()) != null) {
                valXY = mline.split(",");
                Xval = Double.parseDouble(valXY[0]);
                Yval = Double.parseDouble(valXY[1]);
                DataPoint dp = new DataPoint(Xval, Yval);
                arrDataPoint.add(dp);
            }
            DataPoint[] listDp = new DataPoint[arrDataPoint.size()];
            for(int i=0;i<arrDataPoint.size();i++){
                listDp[i]=arrDataPoint.get(i);
            }
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(listDp);
            graph.addSeries(series);
            } catch (IOException e) {
            e.printStackTrace();
        }
graph.getViewport().setXAxisBoundsManual(true);
graph.getViewport().setMinX(0);
graph.getViewport().setMaxX(1);

graph.getViewport().setScrollable(true); // enables horizontal scrolling
graph.getViewport().setScrollableY(true); // enables vertical scrolling

}
}