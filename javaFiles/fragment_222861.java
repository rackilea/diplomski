import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyWindow6 extends JFrame
{
    private final JButton btnNew;
    public static void main(String[] args){
        new Controller2(new MyWindow6());
    }
    public MyWindow6()      {

        btnNew = new JButton( "Delete");
        this.setSize(120,80);
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        add(btnNew, BorderLayout.PAGE_START);
        setVisible(true);
    }

    public JButton getBtnNew() {
        return btnNew;
    }
}

class Controller2 {

    private final MyWindow6 view;

    public Controller2(MyWindow6 v) {

        view = v;
        view.getBtnNew().addActionListener(e -> delete());
    }

    private void delete() {
        System.out.println("delete btn clicked");
    }
}