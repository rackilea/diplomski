String index = null;
for (Map.Entry<String, String> entry : mappedValues.entrySet()) {
    if (champ.equals(entry.getValue())) {
        index = entry.getKey();
        break;
    }
}