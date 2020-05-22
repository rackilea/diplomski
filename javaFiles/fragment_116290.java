public class MainActivity{

//Declare a textview 
private TextView textView;

 protected void onCreate(Bundle savedInstanceState) {
 .....
  textView =(TextView)myView.findViewById(R.id.textView1);
....
 }
....
public void enablemyBluetooth(View view){             

    BluetoothOn ble = new BluetoothOn();

   //Pass textview as argument
    ble.initializeBlue(textView);
    }
}

public class BluetoothOn {

private void initializeBlue(View myView){

textView1 =(TextView)myView.findViewById(R.id.textView1);
textView1.setText(BleisOn);
    }
}