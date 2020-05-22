Runnable c = () -> {
        try{
            while(true)
            {
                tr = queue.take();
                double amount = 0;
                int fromAcct = 0;
                int toAcct = 0;
                amount = tr.getAmount();
                fromAcct = tr.getFromAccount();
                toAcct = tr.getToAccount();
                bank.transfer(fromAcct, toAcct, amount);
            }
        }
        catch(InterruptedException e)
        {
        }
     };
     Thread ct = new Thread(c);
     ct.start();