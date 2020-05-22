import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gmine {
        JFrame interfaceFrame;
        JButton singleplayerButton, multiplayerButton, optionsButton, quitButton;


        public Gmine() {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException ex) {
                    } catch (InstantiationException ex) {
                    } catch (IllegalAccessException ex) {
                    } catch (UnsupportedLookAndFeelException ex) {
                    }

                    interfaceFrame = new JFrame("G-Mine");
                    interfaceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    interfaceFrame.setLayout(new BorderLayout());
                    interfaceFrame.setSize(800,500);
                    //interfaceFrame.setBackground(Color.black);
                    interfaceFrame.add(new MenuPane());
                    interfaceFrame.setLocationRelativeTo(null);
                    interfaceFrame.setVisible(true);
                }
            });
        }

        public class MenuPane extends JPanel {

            public MenuPane() {
                setLayout(new GridBagLayout());

                setOpaque(true);
                setBackground(Color.BLUE);

                singleplayerButton = new JButton("SinglePLayer");
                multiplayerButton = new JButton("MultiPlayer");
                optionsButton = new JButton("Options");
                quitButton = new JButton("Quit");

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.ipadx = 20;
                gbc.ipady = 20;

                add(singleplayerButton, gbc);
                gbc.gridy++;
                add(multiplayerButton, gbc);
                gbc.gridy++;
                add(optionsButton, gbc);
                gbc.gridy++;
                add(quitButton, gbc);
            }
        }
        public static void main(String[] args) {
            new Gmine();
        }
}