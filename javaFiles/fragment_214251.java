public class SkipOnProductionListener implements IMethodInterceptor {

    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        if (isProduction()) {
            list.removeIf(method -> method.getMethod().getRealClass().isAnnotationPresent(SkipIfOnProd.class));
            list.removeIf(method -> method.getMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(SkipIfOnProd.class));
        }
        return list;
    }

    private boolean isProduction() {
        //do some env determination logic here
        return true;
    }

}