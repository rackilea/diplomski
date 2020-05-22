public class CustomKeyGenerator implements KeyGenerator{
    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuilder key = new StringBuilder();
        //include method name in key
        key.append(method.getName());
        if (params.length > 0) {
            key.append(';');
            for (Object argument : params) {
                key.append(argument);
                key.append(';');
            }
        }
        return key.toString();
    }
}