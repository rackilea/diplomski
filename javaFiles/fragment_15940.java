JSONObject jsonObject = JSONObject.fromObject( "{ \"a\": \"a\", \"a\": { \"b\": {},\"b\": true}}" );

System.out.println( "net.sf.json.JSONObject: " + jsonObject );

JsonNode jsonNode = new ObjectMapper().readTree( jsonObject.toString() );

System.out.println( "com.fasterxml.jackson.databind.JsonNode" + jsonNode );