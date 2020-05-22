public static void main(String[] args) throws JsonParseException, JsonMappingException,     IOException {
    String str = "{" + 
            "  \"attributes\": {" + 
            "    \"entry\": [" + 
            "      {" + 
            "        \"key\": \"operating system\"," + 
            "        \"value\": \"GNU/Linux\"" + 
            "      }," + 
            "      {" + 
            "        \"key\": \"allergies\"," + 
            "        \"value\": \"weed\"" + 
            "      }" + 
            "    ]" + 
            "  }" + 
            "}";



    ObjectMapper mapper = new ObjectMapper();
    WrapperObject mj = mapper.readValue(str, WrapperObject.class);

    if(mj == null){
        System.err.println("null");
    }
    // dummy check
    System.out.println(mj.getAttributes().getEntry().get(0).getKey());
}