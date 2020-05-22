Map<String, String> countries = new HashMap<String, String>();
countries.put("United Kingdom", "UK");
countries.put("France", "FR");
for (Map.Entry<String, String> entry : countries.entrySet()) {
  values.replace(entry.getKey(), entry.getValue());
}