/**
 * Get all 'Public', 'Void' , non-static and no-argument methods 
 * in given Class.
 * 
 * @param clazz
 * @return Validate methods list
 */
static List<Method> getValidatePublicVoidNoArgMethods(Class clazz) {

    List<Method> result = new ArrayList<Method>();

    List<FrameworkMethod> methods= new TestClass(clazz).getAnnotatedMethods(Test.class);

    for (FrameworkMethod eachTestMethod : methods){
        List<Throwable> errors = new ArrayList<Throwable>();
        eachTestMethod.validatePublicVoidNoArg(false, errors);
        if (errors.isEmpty()) {
            result.add(eachTestMethod.getMethod());
        }
    }

    return result;
}