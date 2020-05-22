for (int i = 0; i < input.length; i++) {
  // Skip the blank lines
  if (!input[i].trim().equals("")) {

    if (map.containsKey(input[i])) {
      int count = map.get(input[i]);
      map.put(input[i], count + 1);
    } else {
      map.put(input[i], 1);
    }
  }
}