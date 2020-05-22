public static void main(String[] args)
{
    ObjectMapper mapper = new ObjectMapper();
    TypeFactory factory = mapper.getTypeFactory();
    // type of key of response map
    JavaType stringType = factory.constructType(String.class);
    // type of value of response map
    JavaType listOfDtosType = factory.constructCollectionLikeType(ArrayList.class, SingleSummonerBasicDTO.class);
    // create type of map
    JavaType responseType = factory.constructMapLikeType(HashMap.class, stringType, listOfDtosType);

    try (InputStream is = new FileInputStream("C://Temp/xx.json")) {
        Map<String, List<SingleSummonerBasicDTO>> response = new ObjectMapper().readValue(is, responseType);
        System.out.println(response);
    } catch (IOException e) {
        e.printStackTrace();
    }
}