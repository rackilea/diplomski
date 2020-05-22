public static void main(String[] args)
{
    String str = "[ {\"foo\": \"bar\"}, {\"key\": true}, {\"otherKey\": 10} ]";

    try (InputStream is = new ByteArrayInputStream(str.getBytes("UTF-8"))) {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType listWrappersType = objectMapper.getTypeFactory()
                .constructCollectionType(List.class, Wrapper.class);
        List<Wrapper> list = objectMapper.readValue(is, listWrappersType);
        System.out.println(list);
    } catch (Exception e) {
        e.printStackTrace();
    }
}