@Override
public String toString()
{
    String str = "";
    try
    {
        str = objectMapper.writeValueAsString(this);
    } catch (JsonProcessingException e)
    {
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));
        str = "ERROR JSON" + errors.toString();
    }
    return str;
}