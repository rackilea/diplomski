public class JsonSmileMigrationService
{
    private static final Logger log = LoggerFactory.getLogger(JsonSmileMigrationService.class);

    public static byte[] convertToSmile(byte[] json, JsonFactory jsonFactory, SmileFactory smileFactory)
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try // try-with-resources
        (
            JsonGenerator jg = smileFactory.createGenerator(bos);
            JsonParser jp = jsonFactory.createParser(json)
        )
        {
            while (jp.nextToken() != null)
            {
                jg.copyCurrentEvent(jp);
            }
        }
        catch (Exception e)
        {
            log.error("Error while converting json to smile", e);
        }

        return bos.toByteArray();
    }

    public static byte[] convertToJson(byte[] smile, JsonFactory jsonFactory, SmileFactory smileFactory)
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try // try-with-resources
        (
            JsonParser sp = smileFactory.createParser(smile);
            JsonGenerator jg = jsonFactory.createGenerator(bos)
        )
        {
            while (sp.nextToken() != null)
            {
                jg.copyCurrentEvent(sp);
            }
        }
        catch (Exception e)
        {
            log.error("Error while converting smile to json", e);
        }

        return bos.toByteArray();
    }
}