InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_FILE);
InputStreamReader isr = new InputStreamReader(inStream);
BufferedReader br = new BufferedReader(isr); 
for (String s; (s = br.readLine()) != null;) { 
  // using a regex to grab the id to use as a key to the hashmap
  // a full json parser here would be overkill
  Pattern pattern = Pattern.compile("^[A-Za-z]+ = (.*\"id\": \"([A-Za-z_/]+)\".*)$");
  Matcher matcher = pattern.matcher(s);     
  if (matcher.matches()) {
    String id = matcher.group(2);
    String json = matcher.group(1);

    if (!jsonMap.containsKey(id)) {
      jsonMap.put(id, json);
    }
  }
} 
br.close();
isr.close();
inStream.close();