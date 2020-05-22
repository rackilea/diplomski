Account account = (Account) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] {Account.class, Serializable.class},
    new ExampleInvocationHandler());

// method chaining for the win!
account.deposit(5000).deposit(4000).deposit(-2500);
System.out.println("Balance: " + account.getBalance());