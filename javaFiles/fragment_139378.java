import java.awt.Toolkit;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;

public class Main {
    public static void main(String[] args) throws Exception { 
        Toolkit.getDefaultToolkit().getSystemClipboard().addFlavorListener(new FlavorListener() { 
            @Override 
            public void flavorsChanged(FlavorEvent e) { 
                System.out.println("changed!!! " + e.getSource() + " " + e.toString()); 
            } 
        }); 
        Thread.sleep(100000L); 
    }
}