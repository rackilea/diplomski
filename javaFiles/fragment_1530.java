public class JsonFactory {


    private static ObjectMapper json = JsonFactory.create();

    public static ObjectMapper create () {
        JsonParserFactory jsonParserFactory = new JsonParserFactory();
        jsonParserFactory.lax();

        return new ObjectMapperImpl(jsonParserFactory,  new JsonSerializerFactory());
    }
....
)