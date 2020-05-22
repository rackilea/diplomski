Map<String, String> placeholders = new HashMap<String, String>();
// init your placeholders somehow...
placeholders.put("click_tracking_url", "something");

String fragment = "<a href=\"$click_tracking_url$&landing_url=google.com\"><img src=\"10.gif\" /></a>";
Matcher m = Pattern.compile("\\$(\\w+)\\$").matcher(fragment);
if (m.find()) { 
   String processedFragment = m.replaceAll(placeholders.get(m.group(1)));
   System.out.println(processedFragment);
}