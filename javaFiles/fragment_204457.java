String input = str.toLowerCase();
String newInput = input.replaceAll("[0-9]+", "");
String newerInput = input.replaceAll("\\W", "");
String newestInput = newerInput.replaceAll("\\s", "");

System.out.println(newestInput);
while (newestInput.charAt(left) == newestInput.charAt(right) && left < right) {