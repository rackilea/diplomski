import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestTabbedPane {

static JTabbedPane p;
static JFrame f;
public static void main(String[] args) {

    f = new JFrame();
    f.setSize(800,600);
    f.setLocationRelativeTo(null);

    p = new JTabbedPane();
    p.addTab("T1", new JPanel());
    p.addTab("T2", new JPanel());
    p.addTab("T3", new JPanel());

    p.addChangeListener(new ChangeListener() { //add the Listener

        public void stateChanged(ChangeEvent e) {

            System.out.println(""+p.getSelectedIndex());

            if(p.getSelectedIndex()==2) //Index starts at 0, so Index 2 = Tab3
            {
                //do your stuff on Tab 3
            }
        }
    });
    f.add(p);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
}
}