import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.*;

import javax.swing.*;

public class FooGui002 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGui mainGui = new MainGui();
            mainGui.setVisible(true);
        });
    }
}