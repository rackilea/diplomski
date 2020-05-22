import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

// A bank account has a balance that can be changed by deposits and withdrawals.

class BankAccount {

    private double total = 0;

    public void withdraw(double amount) {
        total -= amount;
    }

    public void deposit(double amount) {
        total += amount;
    }

    public double getAccount() {
        return total;

    }
}

class BankAccountManager {

    private static final Lock lock = new ReentrantLock();
    private Condition myCond = lock.newCondition();
    BankAccount myAccount;

    public BankAccountManager(BankAccount myAccount) {
        this.myAccount = myAccount;
    }

    public void amountWithdrawn(double money_Withdrawn)
            throws InterruptedException {
        lock.lock();
        try {
            if (money_Withdrawn > myAccount.getAccount()) {
                myCond.await();
            }
            // when the condition is satisfied then :
            System.out.println("Amount Withdrawn is " + money_Withdrawn);
            myAccount.withdraw(money_Withdrawn);
            System.out.println("Total Amount is " + myAccount.getAccount());
        } finally {
            lock.unlock();
        }
    }

    public void amountDeposited(double money_deposited)
            throws InterruptedException {
        lock.lock();
        try {
            System.out.println("Amount Deposited is " + money_deposited);
            myAccount.deposit(money_deposited);
            System.out.println("Total Amount is " + myAccount.getAccount());
            myCond.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

class Husband implements Runnable {

    private BankAccountManager manager;
    private double amount_deposit;
    private double amount_withdraw;

    public Husband(BankAccountManager manager, double amount_deposit,
            double amount_withdraw) {
        this.manager = manager;
        this.amount_deposit = amount_deposit;
        this.amount_withdraw = amount_withdraw;
    }

    public void run() {
        try {
            manager.amountDeposited(amount_deposit);
            manager.amountWithdrawn(amount_withdraw);
        } catch (InterruptedException ex) {
            Logger.getLogger(Wife.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Wife implements Runnable {

    private BankAccountManager manager;
    private double amount_deposit;
    private double amount_withdraw;

    public Wife(BankAccountManager manager, double amount_deposit,
            double amount_withdraw) {
        this.manager = manager;
        this.amount_deposit = amount_deposit;
        this.amount_withdraw = amount_withdraw;
    }

    public void run() {
        try {
            manager.amountDeposited(amount_deposit);
            manager.amountWithdrawn(amount_withdraw);
        } catch (InterruptedException ex) {
            Logger.getLogger(Wife.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

public class RunningThreadTest {

    public static void main(String[] args) throws InterruptedException {

        BankAccountManager manager = new BankAccountManager(new BankAccount());

        Husband husb = new Husband(manager, 100.0, 0.0);
        Wife wif = new Wife(manager, 400.0, 1.0);
        Thread thread1 = new Thread(husb);
        Thread thread2 = new Thread(wif);
        thread1.start();
        thread2.start();
    }
}