String originalString = "message_type={a&=b}&message_number={1}&code={2}&id={3}&message={a&=b}&timestamp={12}";
Map<String, String> resultMap = new HashMap<String, String>();
String[] splitted1 = originalString.split("&+(?![^{]*})");
for (String str : splitted1) {
    String[] splitted2 = str.split("=+(?![^{]*})");
    resultMap.put(splitted2[0], splitted2[1]);
    splitted2 = null;
}