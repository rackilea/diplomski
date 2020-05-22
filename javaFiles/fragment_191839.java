import java.awt.*;
import javax.swing.*;

class CaptureRA {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                String prefix = "RA";
                JPanel gui = new JPanel(new FlowLayout(4));
                gui.add(new JLabel(prefix));
                SpinnerModel ints = new SpinnerNumberModel(
                        1000000,1000000,99999999,1);
                JSpinner spinner = new JSpinner(ints);
                gui.add(spinner);

                JOptionPane.showMessageDialog(null, gui);
                System.out.println(prefix + ints.getValue());
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}