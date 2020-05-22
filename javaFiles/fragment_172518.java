import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Stack extends JFrame implements ActionListener{
    JTable table;
    JPanel panel = new JPanel();
    JButton button = new JButton("Add");

    String data[][]={{"hey","hey"},{"hey","hey"},{"hey","hey"},{"hey","hey"},    {"hey","hey"},{"hey","hey"}
,{"hey","hey"},{"hey","hey"},{"hey","hey"},{"hey","hey"},{"hey","hey"},{"hey","hey"},{"hey","hey"},{"hey","hey"}
,{"hey","hey"},{"hey","hey"}};
    String columns[] = {"First","Second"};

    public Stack(){
        setLayout(new BorderLayout());
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setPreferredSize(new Dimension(1024,768));
        button.addActionListener(this);
        add(panel,BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

    }

    public static void main(String [] a){
        Stack s = new Stack();
        s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        s.pack();
        s.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        //panel.removeAll();
        table =new JTable(data,columns);
        panel.add(new JScrollPane(table));
        repaint();
        revalidate();
    }
}