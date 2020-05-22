import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame implements ActionListener
{
   int lg = 1000;
   int lrg = 700;
   int h = 2;

   Panel b = new Panel();

   private JButton btn = new JButton("Start");

   JButton bouton = new JButton();

   private JPanel container = new JPanel();
   Panel boutonPane = new Panel();

   public Window()
   {
      this.setTitle("Animation");
      this.setSize(300, 300);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);
      container.setBackground(Color.white);
      container.setLayout(new BorderLayout());
      JPanel top = new JPanel();

      btn.addActionListener(this);
      top.add(btn);
      container.add(top);
      this.setContentPane(container);
      this.setVisible(true);
   }

   public void Window2()
   {

      System.out.println("windows2");

      this.setTitle("ADHD");
      this.setSize(lg, lrg);
      this.setLocationRelativeTo(null);

      bouton.addActionListener(this);

      if (h < 11)
      {

         boutonPane.Panel2(h, Color.BLUE, lg, lrg, this.getGraphics());

         System.out.println("draw" + h);

         boutonPane.add(bouton);

         this.add(boutonPane);
         this.setContentPane(boutonPane);
         updateWindow2();

      }

      this.setVisible(true);

   }

   public void updateWindow2()
   {
      boutonPane.Panel2(h, Color.BLUE, lg, lrg, this.getGraphics());
      this.revalidate();
      this.repaint();
   }

   public void actionPerformed(ActionEvent e)
   {
      if ((JButton) e.getSource() == btn)
      {
         System.out.println("pressed0");
         Window2();

      }
      if ((JButton) e.getSource() == bouton)
      {
         h++;
         System.out.println("pressed" + h);
         updateWindow2();

      }
   }

   public static void main(String[] args)
   {
      Test t = new Test();
   }
}