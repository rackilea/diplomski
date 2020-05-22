Optional<Map.Entry<String, String[]>> entry = generateTimesForStation(i);
if (entry.isPresent()) {
  String key = entry.get().getKey();
  // Do whatever with the key.
} else {
  // Handle the "not found" case.
}