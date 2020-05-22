import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    private final JButton b_show;
    private final JPanel jp_main;

    public Main() {
        jp_main = new JPanel();
        b_show = new JButton("Show");
        b_show.addActionListener(actionEvent -> {
            new Show();
        });
        jp_main.add(b_show);
    }
    public static void main(String[]args){
        JFrame frame=new JFrame();
        frame.setContentPane(new Main().jp_main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}

class Show {
    private JButton b_back;
    public JPanel jpanelmain;


    public Show() {
        createAndShowGui();
    }

    void createAndShowGui(){

        JFrame frame=new JFrame();
        frame.setLocationRelativeTo(null);
        jpanelmain = new JPanel();
        b_back = new JButton("Back");
        jpanelmain.add(b_back);
        frame.setContentPane(jpanelmain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}