public void onMode(View Button){
  EditText inp = (EditText) findViewById(R.id.EditText01);
  float[] input = new float[uno];
  input = points;

  Float floatInput2 = getMode(input);
  String newinput2 = floatInput2.toString();

  if (floatInput2 != null) {
    inp.setText("Your required Mode is "+newinput2);
  } else {
    inp.setText("No mode was found.");
  }
}

public static Float getMode(float[] values) {
  HashMap<Float,Float> freqs = new HashMap<Float,Float>();

  for (float val : values) {
    Float freq = freqs.get(val);
    freqs.put(val, (freq == null ? 1 : freq+1));
  }

  float mode = 0;
  float maxFreq = 0;

  for (Map.Entry<Float,Float> entry : freqs.entrySet()) {
    float freq = entry.getValue();
    if (freq > maxFreq) {
      maxFreq = freq;
      mode = entry.getKey();
    }
  }

  if (maxFreq > 1) {
    return mode;
  } else {
    return null;
  }
}