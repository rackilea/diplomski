Set<String> removed = new TreeSet<String>();
for (Map.Entry<String, ?> entry : Utils.currentPrinters.entrySet()) {

    String key = entry.getKey();

    JsonObject printer = (JsonObject) entry.getValue();

    if (...) {
        removed.add(key);
    }
}
for (String key : removed)
    Utils.currentPrinters.remove(key);