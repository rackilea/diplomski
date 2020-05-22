package expand;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Expand implements ActionListener{

private JFrame frmBasic;
private JPanel panel;
private JButton btnShowMore,
                btnHide;
private JLabel lblAdv;

/**
 * Launch the application.
 */
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                Expand window = new Expand();
                window.frmBasic.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

/**
 * Create the application.
 */
public Expand() {
    initialize();
}

/**
 * Initialize the contents of the frame.
 */
private void initialize() {
    frmBasic = new JFrame();
    frmBasic.setTitle("Basic");
    frmBasic.setBounds(100, 100, 450, 300);
    frmBasic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel();
    frmBasic.getContentPane().add(panel, BorderLayout.CENTER);

    panel.setLayout(new BorderLayout(0, 0));

    btnShowMore = new JButton("Show More");
    btnShowMore.addActionListener(this);
    panel.add(btnShowMore, BorderLayout.NORTH);

    btnHide = new JButton("Hide");
    btnHide.addActionListener(this);
    panel.add(btnHide, BorderLayout.SOUTH);

    JLabel lblNewLabel = new JLabel("Basic user information");
    panel.add(lblNewLabel, BorderLayout.WEST);

    lblAdv = new JLabel("A new item");
    lblAdv.setHorizontalAlignment(SwingConstants.CENTER);
    lblAdv.setVisible(false);
    lblAdv.setEnabled(false);
    lblAdv.setVerticalAlignment(SwingConstants.TOP);
    panel.add(lblAdv, BorderLayout.CENTER);
}

@Override
public void actionPerformed(ActionEvent event) {
    if (event.getSource().equals(btnShowMore)){
        lblAdv.setVisible(true);

    }else if(event.getSource().equals(btnHide)){
        lblAdv.setVisible(false);

    }
    frmBasic.repaint();
}

}