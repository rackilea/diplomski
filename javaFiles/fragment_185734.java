import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class Main {

    public static List<String> list;

    public static void main(String[] args) throws Exception {
        Field field = Main.class.getField("list");
        Type type = field.getGenericType();

        if (type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) type;
            Type[] types = pType.getActualTypeArguments();
            for (Type t : types) {
                System.out.println(t);
            }
        } else {
            System.err.println("not parameterized");
        }
    }

}