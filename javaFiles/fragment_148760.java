public class FindConstructor {

    public static void main(String[] args) throws IOException {
        for (Constructor<?> constructor : MyClass.class.getConstructors()) {
            Type[] parameterTypes = constructor.getGenericParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0] instanceof ParameterizedType) {
                ParameterizedType parameterizedArg = (ParameterizedType) parameterTypes[0];
                if (parameterizedArg.getRawType() != Map.class) {
                    continue;
                }

                if (parameterizedArg.getActualTypeArguments()[0] != String.class) {
                    continue;
                }

                if (parameterizedArg.getActualTypeArguments()[1] != String.class) {
                    continue;
                }
            }
            System.out.println("found constructor " + constructor);
        }
    }
}

class MyClass {
    public MyClass(Map<String, String> map) {
    }
}