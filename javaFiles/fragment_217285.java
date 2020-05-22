Gson gson = new Gson();

// To json:
String result = gson.toJson(yourObject);

// From json:
YourObject object= gson.fromJson(result, YourObject.class);