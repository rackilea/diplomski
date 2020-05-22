package threadLocal;

public class Runner implements Runnable{

    private String userName, password;
    private long acctId;

    public Runner(String user, String pword, long accountId){
        System.out.println("In Runner constructor");
        System.out.println(ThreadLocalManager.accountId.get());
        System.out.println(ThreadLocalManager.accountUsername.get());
        System.out.println(ThreadLocalManager.accountPassword.get());

        userName = user;
        password = pword;
        acctId = accountId;
    }

    @Override
    public void run() {
        System.out.println("Inside Runner's run");
        System.out.println(ThreadLocalManager.accountId.get());
        System.out.println(ThreadLocalManager.accountUsername.get());
        System.out.println(ThreadLocalManager.accountPassword.get());

        ThreadLocalManager.accountId.set(acctId);
        ThreadLocalManager.accountUsername.set(userName);
        ThreadLocalManager.accountPassword.set(password);

        System.out.println("Inside Runner's run - after setting");
        System.out.println(ThreadLocalManager.accountId.get());
        System.out.println(ThreadLocalManager.accountUsername.get());
        System.out.println(ThreadLocalManager.accountPassword.get());
    }

}