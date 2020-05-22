public class App 
{
    public static void main( String[] args )
    {
        String json = "[{\"property\":\"surname\",\"direction\":\"ASC\"}]";
        Type listType = new TypeToken<ArrayList<Pair>>(){}.getType();
        Gson gson = new Gson();
        ArrayList<Pair> myList = gson.fromJson(json, listType);

        for (Pair p : myList)
        {
            System.out.println(p.getProperty());
        }   
    }
}

class Pair
{
    private String property;
    private String direction;

    public String getProperty() 
    {
        return property;
    }    
}