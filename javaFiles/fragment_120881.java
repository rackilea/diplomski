public class JacksonXmlMapper {

    public static void main(String[] args) throws JsonProcessingException {

        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("field1", "v1");
        map.put("field2", 10);
        XmlMapper mapper = new XmlMapper();
        System.out.println(mapper
                .writer()
                .withRootName("root")
                .writeValueAsString(map));

    }
}