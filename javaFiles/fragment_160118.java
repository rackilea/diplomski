Account account = new Account();

InStream.range(0, 50).parallel()
                     .forEach(i -> account.deposit(1));

System.out.println(account.getBalance());