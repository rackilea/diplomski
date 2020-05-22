package myframe;

public class MyFrame extends javax.swing.JFrame{

    public MyFrame(String title){
        super(title);
        setSize(200,100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}