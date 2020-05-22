public static void main( String[] args )
{
    String json = "[{\"property\":\"surname\",\"direction\":\"ASC\"}]";

    Type listType = new TypeToken<ArrayList<HashMap<String,String>>>(){}.getType();

    Gson gson = new Gson();

    ArrayList<Map<String,String>> myList = gson.fromJson(json, listType);

    for (Map<String,String> m : myList)
    {
        System.out.println(m.get("property"));
    }
}