import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.*;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

public class FooProgress  {
    private static void createAndShowGui() {
        JFrame frame = new JFrame("FooProgress");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DownloadPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}