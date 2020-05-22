package stackoverflow.questions.q16715117;

import java.io.IOException;
import java.util.*;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.*;

public class Q16715117 {

    public static void main(String[] args) {
    GsonBuilder gb = new GsonBuilder(); 
    gb.registerTypeAdapterFactory(CUSTOM_ENUM_FACTORY);

    Container c1 = new Container();


    Gson g = gb.create();
    String s1 = "{\"colour\":\"RED\",\"number\":42}";
    c1 = g.fromJson(s1, Container.class);
    System.out.println("Result: "+ c1.toString());
    }


    public static final TypeAdapterFactory CUSTOM_ENUM_FACTORY = newEnumTypeHierarchyFactory();

    public static TypeAdapterFactory newEnumTypeHierarchyFactory() {
        return new TypeAdapterFactory() {
          @SuppressWarnings({"rawtypes", "unchecked"})
          public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
              return null;
            }
            if (!rawType.isEnum()) {
              rawType = rawType.getSuperclass(); // handle anonymous subclasses
            }
            return (TypeAdapter<T>) new CustomEnumTypeAdapter(rawType);
          }
        };
      }


    private static final class CustomEnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> nameToConstant = new HashMap<String, T>();
        private final Map<T, String> constantToName = new HashMap<T, String>();
        private Class<T> classOfT;

        public CustomEnumTypeAdapter(Class<T> classOfT) {
          this.classOfT = classOfT;
          try {
            for (T constant : classOfT.getEnumConstants()) {
              String name = constant.name();
              SerializedName annotation = classOfT.getField(name).getAnnotation(SerializedName.class);
              if (annotation != null) {
                name = annotation.value();
              }
              nameToConstant.put(name, constant);
              constantToName.put(constant, name);
            }
          } catch (NoSuchFieldException e) {
            throw new AssertionError();
          }
        }
        public T read(JsonReader in) throws IOException {
          if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
          }

          String nextString = in.nextString();
          T enumValue = nameToConstant.get(nextString);

          if (enumValue == null)
          throw new GsonEnumParsinException(nextString, classOfT.getName());

          return enumValue;
        }

        public void write(JsonWriter out, T value) throws IOException {
          out.value(value == null ? null : constantToName.get(value));
        }
      }

}