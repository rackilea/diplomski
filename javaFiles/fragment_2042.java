import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelRetriever{

    Box panel1;
    JPanel panel2;

    public PanelRetriever(final JFrame frame){
        //Build the first login panel
        panel1 = Box.createVerticalBox();
        panel1.setBackground(Color.orange);
        panel1.setOpaque(true);
        panel1.add(Box.createVerticalGlue());
        panel1.add(new JTextField(10));
        JButton login = new JButton("Login");
        login.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setContentPane(getPanel2());
                frame.validate();
            }});
        panel1.add(login);
        panel1.add(Box.createVerticalGlue());

        //Build second panel
        panel2 = new JPanel();
        panel2.setBackground(Color.blue);
        panel2.setOpaque(true);
        JButton logout = new JButton("Logout");
        logout.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(getPanel1());
                frame.validate();
            }});
        panel2.add(logout, BorderLayout.CENTER);
    }

    public Container getPanel1(){
        return panel1;
    }

    public Container getPanel2(){
        return panel2;
    }

    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new JFrame();
                PanelRetriever pr = new PanelRetriever(frame);
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                frame.setContentPane(pr.getPanel1());
                frame.setPreferredSize(new Dimension(500, 400));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}