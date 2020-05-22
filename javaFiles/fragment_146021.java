HashMap<String, String[]> map = ...;

// append value to the current value of key
String key = "key";
String value = "value";

// I use an array to hold a reference - even uglier than the whole idea itself ;)
String[] ref = new String[1]; // lightweigt object
String[] prev = map.put(key, ref);
ref[0] = (prev != null) ? prev[0] + value : value;