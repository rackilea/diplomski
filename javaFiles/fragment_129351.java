if (this.getBalance() > amount) {
    if (Thread.currentThread().getName().equals("customer0"))
        try {
            Thread.sleep(1); // simulates a quicker thread context switch
        } catch (InterruptedException e) {}
    this.setBalance(this.getBalance() - amount);
    System.out.println(Thread.currentThread().getName() + " withdraw " + amount);
    System.out.println("Hello,  " + Thread.currentThread().getName() + " You current balance is " + this.getBalance());

    return true;
}