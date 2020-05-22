// this class is used for the arraylist/collection of point X and Y
// on actionscript side you will see the property you declare as public 
public class ChartPoint {
    public String X;
    public String Y;      
}



public class ChartData{          
 // method called from remoteobject from actionscript
 // it will return a java arraylist of type chartpoint
 // actionscript will receive an arraycollection with the property of 
 // ChartPoint you declared public
  public ArrayList<ChartPoint> getValuesFromChart()
  { 
   ArrayList<ChartPoint> chartData = new ArrayList<ChartPoint>();
   ....
   // initialization and fill the chartData list...
   return chartData;
  }
}