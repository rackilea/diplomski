BusTimer bus_timer = new BusTimer(this);



public class BusTimer {


  TextView cMeter;

  public BusTimer(Activity activity){

  cMeter = (TextView) activity.findViewById(R.id.cMetre);

  cMeter.setText("Hi");

 }
}