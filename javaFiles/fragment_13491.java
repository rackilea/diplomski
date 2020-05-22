import java.awt.*;
import javax.swing.*;


public class FunWithPanels extends JFrame {

    public static void main(String[] args) {
        FunWithPanels frame = new FunWithPanels();
        frame.doSomething();
    }

    void doSomething() {
        Container c = this.getContentPane();

        // .. snip unaltered code

        this.pack();
        this.setVisible(true);
    }
}