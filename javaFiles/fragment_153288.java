public class GsonTest {

public static class Student {
    public Object getXXXWhichNeedsFewLogic() {
        return "foo";
    }
}

public static class GetterSerializer<T> implements JsonSerializer<T> {
    @Override
    public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
        if (null == src) {
            return new JsonNull();
        }
        JsonObject obj = new JsonObject();
        for (Method m : src.getClass().getDeclaredMethods()) {
            if (m.getName().startsWith("get") && m.getParameterCount() == 0) {
                try {
                    obj.add(m.getName().substring(3), context.serialize(m.invoke(src)));
                } catch (InvocationTargetException | IllegalAccessException e) {
                }
            }
        }
        return obj;
    }
}
@Test
public void testSerialization() {
    System.out.println(
            new GsonBuilder()
                    .registerTypeAdapter(Student.class, new GetterSerializer<Student>())
                    .create()
                    .toJson(new Student()));
}