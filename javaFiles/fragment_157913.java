import java.lang.reflect.*;
import java.util.*;

public class Test {

    public List<String> getStringList() {
        return null;
    }

    public List<Integer> getIntegerList() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        showTypeParameters("getStringList");
        showTypeParameters("getIntegerList");
    }

    // Only using throws Exception for sample code. Don't do
    // this in real life.
    private static void showTypeParameters(String methodName)
        throws Exception {
        Method method = Test.class.getMethod(methodName);
        Type returnType = method.getGenericReturnType();
        System.out.println("Overall return type: " + returnType);
        if (returnType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) returnType;
            for (Type t: type.getActualTypeArguments()) {
                System.out.println("  Type parameter: " + t);
            }
        } else {
            System.out.println("Not a generic type");
        }
    }
}