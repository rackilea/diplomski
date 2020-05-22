public class Calculator {


    private Frame parent;

    public Calculator(Frame f){
        parent=f;
    }

    public void calculate(){
        new Thread(new Runnable() {
            @Override 
            public void run() 
            {

                for (int i = 0; i <= 100; i++) {
                    try
                    {
                        Thread.sleep(50);

                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }

                    parent.writeOnConsole("Iteration "+i);
                }

            }   
        }).start();


    }
}