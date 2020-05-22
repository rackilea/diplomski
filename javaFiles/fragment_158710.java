public static Map<String, List<String>> splitQuery(URL url) throws UnsupportedEncodingException {
  final Map<String, List<String>> query_pairs = new LinkedHashMap<String, List<String>>();
  final String[] pairs = url.getQuery().split("&");
  for (String pair : pairs) {
    final int idx = pair.indexOf("=");
    final String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
    if (!query_pairs.containsKey(key)) {
      query_pairs.put(key, new LinkedList<String>());
    }
    final String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder.decode(pair.substring(idx + 1), "UTF-8") : null;
    query_pairs.get(key).add(value);
  }
  return query_pairs;
}