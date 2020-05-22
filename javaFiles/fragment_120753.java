public class Manager {
    
    public static void main(String[] args) {
        new Manager();
    }
    
    public Manager() {
        //                         this is anonymous class
        //                              |
        //                              V
        Thread thread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                System.out.println("hi");
            }
        });
        thread.start();
    }
}