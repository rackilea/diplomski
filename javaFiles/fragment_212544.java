public class MyClass {

    private int data1 = 100;
    private String data2 = "hello";
    private List<String> list = new ArrayList<String>() {
      {
        add("String 1");
        add("String 2");
        add("String 3");
      }
    };

    //getter and setter methods needed


}


String str = {"data1":100,"data2":"hello","list":["String 1","String 2","String 3"]};
com.google.gson.Gson gson = new com.google.gson.Gson();

//To convert json string to class use fromJson
MyClass obj = gson.fromJson(str, MyClass .class);

//To convert class object to json string use toJson
String json = gson.toJson(obj);