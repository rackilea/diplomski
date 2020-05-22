// Class field
float[] mSensorValues;
// In onSensorChanged()
mSensorValues = event.values;
// In onCreateSetContentView()
myTextView.setText("Test " + mSensorValues[1]);