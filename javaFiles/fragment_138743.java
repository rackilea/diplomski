public class RoomAdapter implements JsonDeserializer<Room>, JsonSerializer<Room> {
    public Room deserialize(JsonElement json, Type type, JsonDeserializationContext context){
        // Parse the Json to build a Room
    }

    public JsonElement serialize(Room room, Type type, JsonSerializationContext context){
        // Insert magic here!!
    }
}