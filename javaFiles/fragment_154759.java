import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Network {

    Network() throws InterruptedException {

        Visualiser visualiser = new Visualiser();
        JFrame graph = new JFrame();
        graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graph.setLocation(new Point(150,150));
        graph.getContentPane().add(visualiser);
        graph.pack();
        graph.setVisible(true);

        for(int i = 0; i < 100; i++) {
            visualiser.setText(String.valueOf(i));
            Thread.sleep(500);
            visualiser.repaint();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame settings = new JFrame();
        settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settings.add(new JLabel("settings"));
        new Network(); //invoke Network before settings is made visible 
        settings.pack();
        settings.setVisible(true);
    }
}

class Visualiser extends JPanel {

    JLabel lable;
    Visualiser(){
        lable = new JLabel("0");
        add(lable);
    }

    void setText(String s) {
        lable.setText(s);
    }
}