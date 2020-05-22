package developerToolsNotForDeployment;

 import javax.swing.*;
 import java.awt.*;
 import java.util.ArrayList;


 public class OrderGUI extends javax.swing.JFrame {

 ArrayList orders = new ArrayList<>();

 public static void main(String args[]) {
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

/* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            OrderGUI gui = new OrderGUI();
            gui.setTitle("Flexbox Order System");
            gui.setResizable(false);
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setSize(new Dimension(400,400));
            gui.setVisible(true);
        }
    });
}