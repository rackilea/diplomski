package stackoverflow.test;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainClass {

    public MainClass() {
        JFrame frame1 = new JFrame();
        frame1.setLayout(new BorderLayout());
        frame1.add(new CompanyPanel());
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setSize(500, 500);
        frame1.setVisible(true);


        JFrame frame2 = new JFrame();
        frame2.setLayout(new BorderLayout());
        frame2.add(new SchoolPanel());
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setSize(500, 500);
        frame2.setVisible(true);
    }


    public static final void main(String ... args) {
        new MainClass();
    }
}