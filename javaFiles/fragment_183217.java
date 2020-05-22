InputStream in = request.getInputStream();
BufferedReader r = new BufferedReader(new InputStreamReader(in));
StringBuffer buf = new StringBuffer();
String line;
while ((line = r.readLine())!=null) {
  buf.append(line);
} 


Map<String,Object> map=convertJsonToMap(buf.toString());

private Map<String, Object> convertJsonToMap(String json) {

        Map<String, Object> map = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        try {

            // convert JSON string to Map
            map = mapper.readValue(json,new TypeReference<HashMap<String, Object>>() {});

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }