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

class MyData
{
    private ArrayList<Data> dataList;

    //Setters and Getters
}

IService service = restAdapter.create(IService.class);
MyData data = service.getData(); 

ArrayList<Data> list = data.getDataList(); // Retrive arraylist from MyData

Data obj = list.get(0); // Get first element from arraylist

Pojo pojo = obj.getData(); // Get pojo from Data 

Log.e("pojo", pojo.item1 + ", " + pojo.item2);