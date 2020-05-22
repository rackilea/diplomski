import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        GsonBuilder gb = new GsonBuilder();
        registerTypeAdapter(gb, MyClass.class);

        Gson gson = gb.create();
        List data = new ArrayList<>();
        data.add(new MyClass("Bob"));
        data.add(new MyClass("Alice"));

        String listString = gson.toJson(data);
        String soloString = gson.toJson(new MyClass("Test"));

        Object resultList = gson.fromJson(listString, new TypeToken<List<MyClass>>() {}.getType());
        Object resultSolo = gson.fromJson(soloString, MyClass.class);

        System.out.println("RESULT:");
        System.out.println("FROM " + listString +" TO "+ resultList);
        System.out.println("FROM " + soloString +" TO "+ resultSolo);

    }

    private static void registerTypeAdapter(GsonBuilder gsonBuilder, Class<?> clazz) {
        gsonBuilder.registerTypeAdapter(clazz, new SingleDeserializer());
        Type type = ParameterizedTypeImpl.make(List.class, new Type[]{clazz}, null);
        gsonBuilder.registerTypeAdapter(type, new ListDeserializer());
    }

    private static class ListDeserializer implements JsonDeserializer {
        private static Gson gson = new Gson();

        @Override
        public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            System.out.println("Used ListDeserializer:  Type " + typeOfT);

            Type t = (typeOfT instanceof ParameterizedType) ?
                    ((ParameterizedType) typeOfT).getActualTypeArguments()[0] :
                    Object.class;

            Type type = ParameterizedTypeImpl.make(List.class, new Type[]{t}, null);
            List list = gson.fromJson(json, type);
            return list;
        }
    }

    private static class SingleDeserializer implements JsonDeserializer {
        private static Gson gson = new Gson();

        @Override
        public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            System.out.println("Used SingleDeserializer:  Type " + typeOfT);
            return gson.fromJson(json, typeOfT);
        }
    }

    public static class MyClass {
        @SerializedName("name")
        private String name;

        public MyClass(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "MyClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}