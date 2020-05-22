public static void main(String[] args) throws JsonProcessingException {

        List<String> strings = new ArrayList<>();
        strings.add("string 1");
        strings.add("string 2");
        strings.add(null);
        strings.add(null);

        ObjectMapper mapper=new ObjectMapper();
        mapper.getSerializerProvider().setNullValueSerializer(new NullSerializer());
        System.out.println(mapper.writeValueAsString(strings));
    }