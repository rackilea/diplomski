HashMap<String, HashMap> map = // You already have that
Data[] data = convertMap2Data(map);

Gson gson = new GsonBuilder().setPrettyPrinting().create();
System.out.println(gson.toJson(data[0])); // If there is only one root use this
//System.out.println(gson.toJson(data));  // If there are multiple root