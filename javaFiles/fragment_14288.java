public class Account {
    Account() {

    }

    Account(double x) {

    }
}

public class SafeAccount extends Account {
    private SafeAccount() {

    }

    private SafeAccount(double amount) {
        super(amount);
    }

    public static SafeAccount boo(double x) {
        if (x < 0.0) {
            return new SafeAccount();
        }
        return new SafeAccount(x);
    }
}