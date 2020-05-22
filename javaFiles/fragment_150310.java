class Handler implements java.lang.reflect.InvocationHandler {
    Object target;

    Handler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before " + method.getName());
        Object res = method.invoke(target, args);
        System.out.println("After " + method.getName());
        return res;
    }
}
List list = new ArrayList();
List proxy = (List) Proxy.newProxyInstance(Test.class.getClassLoader(),
        new Class[] { List.class }, new Handler(list));
proxy.add(1);