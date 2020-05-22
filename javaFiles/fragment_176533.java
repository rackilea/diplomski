private static final String yamlString =
    "data_lists:\n" +
    "      list1:  \n" +
    "        - AA: true\n" +
    "          BB: true\n" +
    "          CC: \"value\"\n" +
    "        - AA: false\n" +
    "          BB: true\n" +
    "          CC: \"value2\"";

public static void main(String[] args) throws Exception {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    Map<String, Map<String, List<BLA>>> fileMap = mapper.readValue(
        yamlString, 
        new TypeReference<Map<String, Map<String, List<BLA>>>>(){});
    Map<String, List<BLA>> dataLists = fileMap.get("data_lists");
    List<BLA> blas = dataLists.get("list1");
    System.out.println(blas);
}

class BLA {
    @JsonProperty("AA")
    private boolean aa;
    @JsonProperty("BB")
    private boolean bb;
    @JsonProperty("CC")
    private String cc;

    @Override
    public String toString() {
        return aa + "|" + bb + "|" + cc;
    }

    // Getters/Setters
}