import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class App {
    static JFrame hideOwnedWindows(JFrame f) {
        ArrayList<Window> arHidden = new ArrayList();
        WindowAdapter wa = new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                for (Window w : arHidden)
                    w.setVisible(true);
                f.removeWindowListener(this);
            }
        };
        for (Window w : f.getOwnedWindows()) {
            if (w.isVisible()) {
                w.setVisible(false);
                arHidden.add(w);
            }
        }
        f.addWindowListener(wa);
        return f;
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("App Frame");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btnDialog = new JButton("JDialog");
        JButton btnOptionPane = new JButton("JOptionPane");

        btnDialog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog dlg = new JDialog(f, "Modeless Dialog", false);
                dlg.setSize(256, 256);
                dlg.setLocationRelativeTo(f);
                dlg.setVisible(true);
            }
        });

        btnOptionPane.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(hideOwnedWindows(f), "Confirm JOptionPane");
            }
        });

        f.add(btnDialog, BorderLayout.WEST);
        f.add(btnOptionPane, BorderLayout.EAST);
        f.setSize(512, 512);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}