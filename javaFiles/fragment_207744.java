public class MainActivity extends AppCompatActivity implements SensorEventListener{
  int counter=0;

  //Define the sensor Manager
  SensorManager sm;

  //Define the Motion Sensor objects
  Sensor accelerometer;
  Sensor gravity;

  // and so on