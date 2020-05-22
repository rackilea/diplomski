public class UserSerializer implements JsonSerializer<User> {
    @Override
    public JsonElement serialize(User src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.id + "_" + src.username);
    }
}