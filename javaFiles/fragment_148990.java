class YourClass {
    private String name;

    // getters and setters...
}

YourClass object = new YourClass();
object.setName("MyName");
print(new Gson().toJson(object));