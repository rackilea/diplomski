import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class Sandbox extends JFrame
{
    class MyPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            g.setColor(Color.RED);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
    }

    public static void main(String[] args)
    {
        Sandbox s = new Sandbox();
    }

    public Sandbox()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        MyPanel panelRight = new MyPanel();
        panelRight.setPreferredSize(new Dimension(150, 300));
        this.getContentPane().add(panelRight, BorderLayout.EAST);

        JPanel panelCenter = new JPanel();
        this.getContentPane().add(panelCenter, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(new JTable());
        panelCenter.add(scrollPane);

        JPanel panelBottom = new JPanel();
        this.getContentPane().add(panelBottom, BorderLayout.SOUTH);

        this.setSize(400, 400);
        this.setVisible(true);
    }
}