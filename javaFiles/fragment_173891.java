public class ResponseData
{
    public int success;
    public Map<String, Map<String, Dvd>> response;

    public class Dvd
    {
        public String rating;
    }
}