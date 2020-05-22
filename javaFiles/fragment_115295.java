private class ExampleInvocationHandler implements InvocationHandler {

    private double balance;

    @Override
    public Object invoke (Object proxy, Method method, Object[] args) throws Throwable {

        // simplified method checks, would need to check the parameter count and types too
        if ("deposit".equals(method.getName())) {
            Double value = (Double) args[0];
            System.out.println("deposit: " + value);
            balance += value;
            return proxy; // here we use the proxy to return 'this'
        }
        if ("getBalance".equals(method.getName())) {
            return balance;
        }
        return null;
    }
}