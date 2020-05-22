BufferedReader br = ...
Map<String, Value> map = new HashMap<String, Value>();

String line;
while ((line = br.readLine()) != null) {
    ...
    String key = line.substring(...);
    map.put(key, ...);
}