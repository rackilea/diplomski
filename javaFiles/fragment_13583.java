public class CustomAccessorNamingStrategy extends DefaultAccessorNamingStrategy {

    @Override
    public boolean isGetterMethod(ExecutableElement method) {
        if (method.getSimpleName().toString().equals("getList")) {
            return false;
        } else {
            return super.isGetterMethod(method);
        }
    }
}