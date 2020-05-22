public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        // get B somehow
        A a = new B();

        // get proxy for B 
        A proxy = createProxyFor(a, executorService);

        // call proxy
        System.out.println("current thread: "+Thread.currentThread().getName());

        int resultA = proxy.a(1,2,3);
        System.out.println("calling a returned "+resultA);

        int resultB = proxy.b(1);
        System.out.println("calling b returned "+resultB);

    }

    static A createProxyFor(A a, ExecutorService executorService){
        InvocationHandler h = new MyInvocationHandler(a, executorService);
        A proxy = (A)Proxy.newProxyInstance(A.class.getClassLoader(), new Class[]{A.class}, h);
        return proxy;
    }
}