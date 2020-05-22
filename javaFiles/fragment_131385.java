import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Azad
 */
public class ShowListDemo extends JFrame implements ActionListener{
    private java.util.List<String> list;

    public ShowListDemo(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        JButton show = new JButton("Show List Content");
        show.addActionListener(this);
        p.add(show);

        list = new ArrayList<>();
        list.add("infromation one");
        list.add("information two");
        list.add("information three");

        add(p);
        setLocationRelativeTo(null);
        pack();
    }

    public static void main(String...args){
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
              new ShowListDemo().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String  s = "" ;
        for(String a : list)
            s += a +"\n";
        JOptionPane.showMessageDialog(this, s);//@Mad programmer's recommended, I can't refuse :)
    }
}