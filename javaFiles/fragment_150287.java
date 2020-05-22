public class ThreadTest2 {
    private final static int size = 10;

    public static void main(String[] args) throws InterruptedException {

        Account bank = new Account(size,1000);
        for(int i=0; i<10; i++){
            Transfer t1 = new Transfer(bank, size);
            Thread bankTransfer = new Thread(t1);
            bankTransfer.start();
        }
    }

}

class Account{

    public static int u = 0;
    double[] account;
    int size;
    boolean[] waiting;
    public Account(int size, double initValue){
        account = new double[size];
        this.size = size;
        for(int i=0; i<size; i++){
            account[i] = initValue;
        }
        waiting = new boolean[size];
        for(int i=0;i<size;i++)
            waiting[i] = false;
    }

    public synchronized double getTotalBalance(){
        double total = 0;
        for(int i=0;i<size;i++)
            total+=account[i];
        return total;
    }

    public int getSize(){
        return size;
    }

    public double getBalance(int i){
        return account[i];
    }


    public synchronized void transfer(int from, int to, double amount) throws InterruptedException{
        if(from!=to && waiting[from]!=true){
        int i = 0;
        System.out.printf("Account no %d balance: %.2f subtracts %.2f adds to %d\n", from, getBalance(from),amount,to);
        if(account[from]-amount<0){ i++; u++;}
            while(account[from]-amount<0){
                waiting[from] = true;
                wait();

            }

            if(i==1){ u--; waiting[from] = false;}
            account[from]-=amount;
            System.out.println(" ");
            account[to]+=amount;
            System.out.printf("Total balance: %.2f thread awaiting: %d\n",getTotalBalance(), u);    

            notifyAll();
        }
        }

}

class Transfer implements Runnable{
    Account bank;
    int size;
    public Transfer(Account bank, int size){
        this.bank=bank;
        this.size = size;
    }

    public void run(){
        while(true){
        try {
            bank.transfer((int)(size * Math.random()), (int)(size * Math.random()), 999*Math.random());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }
}