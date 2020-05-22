String text = "A=B&C=D&E=F";

Map<String, String> map = new LinkedHashMap<String, String>();

for(String keyValue : text.split(" *& *")) {
    String[] pairs = keyValue.split(" *= *", 2);
    map.put(pairs[0], pairs.length == 1 ? "" : pairs[1]);
}