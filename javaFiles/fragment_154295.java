import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class Frame extends JFrame implements ActionListener
{
    private JList list;
    private JButton checkButton;

    public Frame()
    {
        setBounds(100,100,300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] nameList = { "Value 1", "Value 2", "Value 3", "Value 4", "Value 5" };
        list = new JList(nameList);
        checkButton = new JButton("Check");
        checkButton.addActionListener(this);

        // add list to frame
        JPanel panel = new JPanel();
        panel.add(list);
        panel.add(checkButton);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Frame();
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Check"))
        {
            int index = list.getSelectedIndex();
            System.out.println("Index Selected: " + index);
            String s = (String) list.getSelectedValue();
            System.out.println("Value Selected: " + s);
        }
    }
}