public static MyPersonnalObject rescure(String jsonStr)
{
    MyPersonnalObject b = null;

    try
    {
        JsonParser jsonParser = jsonFactory.createParser(jsonStr);
        b = objectMapper.readValue(jsonParser, MyPersonnalObject.class);

    } catch (JsonParseException e)
    {
        e.printStackTrace();
    } catch (IOException e)
    {
        e.printStackTrace();
    }
    return b;
}