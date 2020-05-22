Vector<Vector<Float>> data = new Vector<Vector<Float>>();
data.add(new Vector<Float>());
data.get(0).add(3.0f);

String dataAsJson = new Gson().toJson(data, DATA_TYPE);
sharedPreferences.edit().putString("data", dataAsJson).commit();