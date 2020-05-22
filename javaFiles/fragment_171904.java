import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class GUI
{
    public String that_one; // the string you want to change
}

public class AskCityPermit extends JFrame implements Runnable{
    String string;
    GUI gui;
    public static final long serialVersionUID = 1L;

    public AskCityPermit(GUI gui, ArrayList<String> cities){
        this.gui=gui;
        int i=0;
        JPanel textPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        // JButton[] buttons = new JButton[15];
        // create action listener object:
        ActionListener btnaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gui.that_one = ((JButton) ae.getSource()).getText();
            }
        };
        for (String s:cities){
            JButton button =new JButton(s);
            buttonsPanel.add(button);
            // bind action listener to each button:
            button.addActionListener(btnaction);
        }


        this.setLayout(new BorderLayout());
        textPanel.setLayout(new FlowLayout());
        buttonsPanel.setLayout(new FlowLayout());

        textPanel.add(new JLabel("Choose a city"));

        this.add(textPanel,BorderLayout.NORTH);
        this.add(buttonsPanel,BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void run() {
    }

    public static void main(String [] args)
    {
        ArrayList<String> cities = new ArrayList<String>();
        cities.add("City A");
        cities.add("City B");
        cities.add("City C");
        GUI gui = new GUI();
        AskCityPermit frm = new AskCityPermit(gui, cities);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frm.setVisible(true);
            }
        });
    }
}