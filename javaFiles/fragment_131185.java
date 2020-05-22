package example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTester implements Runnable {
    private Account account;
    private double amount;

    public AccountTester(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    public static void main(String[] args) {
        Account account = new Account(0);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new AccountTester(account, 1.0));
        executorService.execute(new AccountTester(account, 2.0));
        executorService.shutdown();
        System.out.println("End balance: " + account.getBalance());
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            account.deposit(amount);
        }
    }
}