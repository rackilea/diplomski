public class GsonContainer{
    public boolean successful;

    public ResultObject resultObject;

    public static class ResultObject{
        public Map<String, List<City>> areas;
    }
}//end class