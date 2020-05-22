List<String> priorities = Arrays.asList("Low", "Medium", "Warning", "Alert", "Crash");
Map<List<String>> data = new LinkedHashMap<List<String>>();
for (String priority : priorities)
  data.put(priority, new ArrayList<String>());

...