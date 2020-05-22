String result;
if (listOfStrings.isEmpty()) {
  result = "";
} else {
  StringBuilder sb = new StringBuilder();
  Iterator<String> it = listOfStrings.iterator();
  sb.append('"').append(it.next()).append('"'); // Not empty
  while (it.hasNext()) {
    sb.append(", \"").append(it.next()).append('"');
  }
  result = sb.toString();
}