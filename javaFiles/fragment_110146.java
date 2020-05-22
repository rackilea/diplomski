Pattern jsonPattern = Pattern.compile("^[^\\{]*(.+)");
Matcher jsonMatcher = jsonPattern.matcher(result);
if (jsonMatcher.find())
{
   String json = jsonMatcher.group(0);
   JSONObject jsonObj = new JsonParser().parse(json).getAsJsonObject();
}
else
{
   // Log that match was not found for result
}