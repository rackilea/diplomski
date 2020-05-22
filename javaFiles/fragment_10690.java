import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class MyFrame extends JFrame {
private JButton[] arrayButton = new JButton[9];
    private JButton btnLeft = new JButton("<");
    private JButton btnRight = new JButton(">");
    private JScrollPane scpButtons = new JScrollPane();

    public MyFrame() {
        for (int i = 0; i < arrayButton.length; i++)
            arrayButton[i] = new JButton("btn");

        JMenu mnuSettings = new JMenu("MENU");
        JMenuBar menubar = new JMenuBar();
        menubar.add(mnuSettings);
        setJMenuBar(menubar);

        JPanel pnlButton = initPnlButton();
        scpButtons.setViewportView(pnlButton);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(scpButtons, BorderLayout.CENTER);

        pack();
        // [1]
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setSize(getWidth() + 1, getHeight() + 1);
        // [2]
        setVisible(true);
        // SwingUtilities.invokeLater(new Runnable() {
        // public void run() {
        applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//here
        scpButtons.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        // }
        // });
    }

    private JPanel initPnlButton() {
        JPanel pnlButton = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1, 1, 10,
                1, new Insets(0, 0, 0, 0), 0, 0);

        int ind = 0;
        int row = 3;
        int column = 4;
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < column; j++) {
                gbc.gridx = j;
                gbc.gridy = i;
                pnlButton.add(arrayButton[ind++], gbc);
            }
        }
        gbc.weightx = 0;
        gbc.gridheight = 3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlButton.add(btnRight, gbc);
        gbc.gridx = 4;
        gbc.gridy = 0;
        pnlButton.add(btnLeft, gbc);
        pnlButton.setPreferredSize(new Dimension(1000, 700));
        return pnlButton;
    }

    public static void main(String[] args) {
        new MyFrame();
    }