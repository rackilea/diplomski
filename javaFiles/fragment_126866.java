class Pojo
{
    private String item1;
    private String item2;

    //Setters and Getters
}

class Data
{
    private Pojo data;

    //Setters and Getters
}

ArrayList<Data> yourArray = new Gson().fromJson(jsonString, new TypeToken<List<Data>>(){}.getType());