public enum Transaction {
    DEPOSIT {
        @Override public void perform(double amount) {
             // code that puts amount to deposit
        }
    },
    PAYOUT {
        @Override public void perform(double amount) {
             // code that pays specified amount 
        }
    },
    ;
    public abstract void perform(double amount);
}