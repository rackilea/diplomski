public static class Entity {
    volatile int id;
    String name;
    transient long random;

    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
//Create new entity
Entity entity = new Entity(100, "name");
entity.random = 1234;

//Serialize to JSON. Then you can save string to file
String json = gson.toJson(entity); // {"id":100,"name":"name"}
// On application start you can deserialize your entity from file
Entity read = gson.fromJson(json, Entity.class);