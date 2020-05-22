String url = baseUrl + "/upload?x={x}&y={y}";

  Map<String, String> uriVariables = new HashMap();
  uriVariables.put("x", "valueForX");
  uriVariables.put("y", "valueForY");

  String response = rest.postForObject(url, null, String.class, uriVariables);