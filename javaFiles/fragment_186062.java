String[] keyValuePairs = line.split(";");
for (String keyValuePair:keyValuePairs) {
  if (isThrowAwayParameter(keyValuePair)) {
    handleThrowAwayParameter();
  } else {
    String[] keyAndValue = keyValuePair.split("=");
    String key = keyAndValue[0];
    String value = keyAndValue[1];
    handleKeyAndValue(key, value);
  }
}