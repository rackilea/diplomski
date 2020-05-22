private void record(int type)
{
  JWoL.setText(strings[type]);
  counts[type]++;
  labels[type].setText(""+counts[type]);
}