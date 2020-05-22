public class TestD implements Runnable {

    private ScheduledExecutorService executor = null;

    public TestC(){
        executor = Executors.newScheduledThreadPool(1);
    }

    @Override
    public void run() {
        try {
             File file = new File("D:/FileD.txt");
             boolean fvar = file.createNewFile();
             if (fvar){
                  System.out.println("File has been created successfully");
             }
             else{
                  System.out.println("File already present at the specified location");
             }
            } catch (IOException e) {
                System.out.println("Exception Occurred:");
                e.printStackTrace();
          }
    }

    public void executeScheduler() throws SQLException {
        executor.scheduleAtFixedRate(this, 2, 5, TimeUnit.SECONDS);
    }

    public static void main(String args[]){
        TestD testD = new TestD();
        try {
            testD.executeScheduler();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}