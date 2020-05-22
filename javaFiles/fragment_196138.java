String input = "I can t do it because it s not raining and it doesn t make sense.";
Map<String, String> cnts = new HashMap<>();
cnts.put("doesn t", "doesn't");
cnts.put("can t", "can't");
cnts.put("haven t", "haven't");
cnts.put("aren t", "aren't");
cnts.put("it s", "it's");
cnts.put("isn t", "isn't");
for (Map.Entry<String, String> entry : cnts.entrySet()) {
    String start = entry.getKey();
    String end = entry.getValue();
    input = input.replaceAll("\\b" + start + "\\b", end);
}
System.out.println(input);