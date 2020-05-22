import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainWindow extends JFrame {

    private static final long serialVersionUID = 6755417048009930291L;

// begin gui components
    JButton clearButton = null;
    JButton dcomp = null;
    JPanel buttonsPanel = null;
    DrawPanel drawPanel = null;
// end gui components


    public MainWindow(){

        // Add ButtonPanel
        add(getDrawPanel(), BorderLayout.CENTER);
        add(getButtonPanel(), BorderLayout.SOUTH);

        // Add Buttons
        getButtonPanel().add(getDcomp());
        getButtonPanel().add(getClearButton());

        addMouseListener(getDrawPanel());
    }


// begin getters and setters for gui components
    private DrawPanel getDrawPanel(){
        if(drawPanel == null){
            drawPanel = new DrawPanel();
            drawPanel.setVisible(true);
        }

        return drawPanel;
    }

    private JPanel getButtonPanel() {
        if(buttonsPanel == null){
            buttonsPanel = new JPanel();
            buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            buttonsPanel.setPreferredSize(new Dimension(500, 100));
        }

        return buttonsPanel;
    }

    private JButton getClearButton() {
        if(clearButton == null){
            clearButton = new JButton("Clear");
            clearButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    getDrawPanel().clearLines();
                }
            });
        }

        return clearButton;
    }

    private JButton getDcomp() {
        if(dcomp == null){
            dcomp = new JButton("Complete");
            dcomp.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    getDrawPanel().createmesh();
                    getDrawPanel().repaint();
                }
            });
        }
        return dcomp;
    }
// end begin getters and setters for gui components



    //as always program entry-point
    public static void main(String[] args) {
        MainWindow wnd = new MainWindow();

        wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wnd.setPreferredSize(new Dimension(500, 600));
        wnd.setLocationRelativeTo(null);
        wnd.pack();
        wnd.setVisible(true);
    }

}