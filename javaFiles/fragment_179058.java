ObjectMapper mapper = new ObjectMapper();
Response r = mapper.readValues(json, Response.class);
Value val = r.response.get(0).values.get(0);
if (val.value instanceof Map)
    ; // multiple
else
    ; // single