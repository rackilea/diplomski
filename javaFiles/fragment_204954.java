import java.util.concurrent.CountDownLatch;

public class DevTest {

    static class Developer implements Runnable {

        CountDownLatch waitingForDeveloper=null;
        CountDownLatch waitingForTester   =null;

        public Developer(CountDownLatch waitingForDeveloper,CountDownLatch waitingForTester) {
            this.waitingForDeveloper=waitingForDeveloper;
            this.waitingForTester=waitingForTester;

        }
        @Override
        public void run(){

            System.out.println("Dev "+Thread.currentThread().getName()+" has completed the task");
            waitingForDeveloper.countDown();
            try{
                waitingForTester.await();
            }catch(InterruptedException ex){}
            System.out.println("Dev "+Thread.currentThread().getName()+" is Working on the bug raised by testers.");


        }
    }

    static class Tester implements Runnable {

        CountDownLatch waitingForDeveloper=null;
        CountDownLatch waitingForTester   =null;

        public Tester(CountDownLatch waitingForDeveloper,CountDownLatch waitingForTester) {
            this.waitingForDeveloper=waitingForDeveloper;
            this.waitingForTester=waitingForTester;

        }
        @Override
        public void run(){

            try{
                waitingForDeveloper.await();
            }catch(InterruptedException ex){}

            System.out.println("Tester "+Thread.currentThread().getName()+" has completed testing.");
            waitingForTester.countDown();

        }
    }
    public static void main(String[] args) {

        int noOFdevelopers=7;
        int noOFTesters=4;
        CountDownLatch waitingForDeveloper=new CountDownLatch(noOFdevelopers);
        CountDownLatch waitingForTester   =new CountDownLatch(noOFTesters);

        Developer developer=new Developer(waitingForDeveloper, waitingForTester);
        Tester    tester=new Tester(waitingForDeveloper, waitingForTester);

        for(int i=1;i<=noOFTesters;i++){
            new Thread(tester,""+i).start();
        }       
        for(int i=1;i<=noOFdevelopers;i++){
            new Thread(developer,""+i).start();
        }


    }
}