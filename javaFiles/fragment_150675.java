String s0 = "This is a text&aThis is a test &bstring that &ehas plenty &4&lof &7colors.";
String colorRx = "&[A-Fa-fK-Ok-or0-9]";
String nonColorRx = "[^&]*(?:&(?![A-Fa-fK-Ok-or0-9])[^&]*)*";
Pattern pattern = Pattern.compile("(?:" + colorRx + ")+" + nonColorRx + "|" + nonColorRx);
Matcher m = pattern.matcher(s0);
List<String> res = new ArrayList<>();
while (m.find()){
    if (!m.group(0).isEmpty()) res.add(m.group(0)); // Add if non-empty!
} 
System.out.println(res); 
// => [This is a text, &aThis is a test , &bstring that , &ehas plenty , &4&lof , &7colors.]