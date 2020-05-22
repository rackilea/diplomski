double maxValue = null;
List<MyObject> maxKeys = new ArrayList<>();
for (Map.Entry<MyObject, Double> entry : map.entrySet()) {
  if (maxValue == null || maxValue.equals(entry.getValue())) {
    maxValue = entry.getValue();
    maxKeys.add(entry.getKey());
  } else if (entry.getValue() > maxValue) {
    maxValue = entry.getValue();
    maxKeys.clear();
    maxKeys.add(entry.getKey());
  }
}