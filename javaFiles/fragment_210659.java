public class MyClassWebArgumentResolver implements WebArgumentResolver {
    public Object resolveArgument(MethodParameter param, NativeWebRequest req) throws Exception {
        if (param.getParameterType().equals(MyClass.class)) {
            MyCLass obj = new MyClass();
            ....
            return obj;
        }
        return UNRESOLVED;
    }

}