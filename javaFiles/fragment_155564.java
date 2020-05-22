import org.json.JSONArray;

String[] msgArray = {"aaa", "bbb", "ccc"};

// serializing
String msg = Arrays.toString(msgArray);

// deserializing
JSONArray jsonArray = new JSONArray(msg);
System.out.println(jsonArray.toList());