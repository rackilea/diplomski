public void withdraw(long n) {
    queueAction(new Withdrawal(n));
}

public void deposit(long n) {
    queueAction(new Deposit(n));
}

void queueAction(Action action) {
    action.doAction();
    if (actionsList.size() >= 10)
        actionsList.poll();
    actionsList.offer(aaction);
}