package inheritableThreadLocal;

public class Runner implements Runnable{

    @Override
    public void run() {
        System.out.println("Inside Runner's run");
        System.out.println(ThreadLocalManager.accountId.get());
        System.out.println(ThreadLocalManager.accountUsername.get());
        System.out.println(ThreadLocalManager.accountPassword.get());
    }

}