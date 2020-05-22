String input = ...
String[] data = input.split(" ");
String[] keys = data[0].split("/");
String[] values = data[1].split("/");

Map<String, Integer> map = new HashMap<>();
for (int i = 0; i < keys.length; i++) {
    map.put(keys[i], Integer.valueOf(values[i]));
}