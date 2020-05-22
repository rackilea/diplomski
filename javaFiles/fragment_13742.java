public class Method1 implements Runnable {
    public void run() {
       // execute method1
    }
}

public class Method2 implements Runnable {
    public void run() {
       // execute method2
    }
}

public class Method3 implements Runnable {
    public void run() {
       // execute method3
    }
}

public class Function {
    private ExecutorService executor = Executors.newFixedThreadPool(3);

    public void solve(pass1, pass2) {
        Method1 method1 = new Method1(pass1, pass2);
        Method2 method2 = new Method2(pass1, pass2);
        Method3 method3 = new Method3(pass1, pass2);
        executor.submit(method1);
        executor.submit(method2);
        executor.submit(method3);
    }
}