public void transfer(Account a,Account b,int amount)
    {
        synchronized(a)
        {
            a.withdraw(amount);
            System.out.print(amount+" is withdrawn from account a\n");

            try{Thread.sleep(500);}
            catch(Exception e){System.out.println(e);}
        }
        synchronized(b)
        {
            b.deposit(amount);
            System.out.print(amount+" is deposited into account b\n");
        }
    }