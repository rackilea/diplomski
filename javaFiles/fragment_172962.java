import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {

    public Test() {
        start();
    }

    public final void start() {

        Timer t=new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Firing!");
            }
        });
        t.start();        
    }
    public static void main(String... args) {
        Test shot=new Test();   

        synchronized(shot){
            try {
                //this causes the Main thread to block, keeping the program running
                shot.wait();
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }    
}