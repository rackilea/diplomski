import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Applet extends JApplet
{
    JPanel p1;
    JPanel p2;
    JPanel p3;

    JScrollPane s1;



    public Applet()
    {
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        s1 = new JScrollPane(p3,s1.VERTICAL_SCROLLBAR_ALWAYS,s1.HORIZONTAL_SCROLLBAR_ALWAYS);


    }

    @Override
    public void init()
    {
        super.init();
        for(int i=0;i<100;i++)
        {
            p3.add(new JButton("Hello"));
            p3.add(new JLabel("blah"));
            p3.add(new JButton("Sup"));
        }

        p1.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
        p2.setPreferredSize(new Dimension(this.getWidth(),(int) (this.getHeight()*0.6667)));

        p3.setLayout(new BoxLayout(p3,BoxLayout.PAGE_AXIS));
        s1.setPreferredSize(new Dimension(this.getWidth(),(int)(this.getHeight()*0.33333)));

        p1.add(p2);
        p1.add(s1);

        this.add(p1);
    }

}