@Override
public void onClick(View v) {
    //I need to store the results then move to the next activity shown below?
    Bundle data = new Bundle();
    data.putString(key, value);
    data.putInt(key, value);
    Intent i = new Intent(EnterAgeActivity.this, EnterWeightActivity.class);
    i.putExtra("data", data);
    startActivity(i);
}