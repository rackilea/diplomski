package demo;
import static demo.ListenerProxies.actionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Demo {

  public static void main(String[] args) {
    Demo test = new Demo();
    JButton hello = new JButton("Say Hello");
    hello.addActionListener(actionListener(test, "sayHello"));
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(hello);
    frame.pack();
    frame.setVisible(true);
  }

  public void sayHello(ActionEvent event) {
    System.out.println("Hello");
  }
}