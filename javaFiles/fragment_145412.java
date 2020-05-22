package threadLocal;

public class ThreadLocalMain {

    public static void main(String[] args) {
        System.out.println("At start of main");
        System.out.println(ThreadLocalManager.accountId.get());
        System.out.println(ThreadLocalManager.accountUsername.get());
        System.out.println(ThreadLocalManager.accountPassword.get());

        Thread t1 = new Thread(new Runnable(){

            @Override
            public void run() {
                ThreadLocalManager.accountId.set(new Long(12345));
                ThreadLocalManager.accountUsername.set("user1");
                ThreadLocalManager.accountPassword.set("pass1");

                System.out.println("In t1 run");
                System.out.println(ThreadLocalManager.accountId.get());
                System.out.println(ThreadLocalManager.accountUsername.get());
                System.out.println(ThreadLocalManager.accountPassword.get());

                Thread t2 = new Thread(new Runner(ThreadLocalManager.accountUsername.get(),
                        ThreadLocalManager.accountPassword.get(),
                        ThreadLocalManager.accountId.get()));
                t2.start();
            }

        });
        t1.start();
    }

}