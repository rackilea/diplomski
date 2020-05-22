import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BookQuizGUI extends JFrame implements ActionListener {
   private static final String HOME = "home";
   private static final String ADD_Q = "add q";
   private JFrame f;
   private JPanel card;
   private JPanel home;
   private JPanel contentPane;
   private JPanel pnlButtons;
   private JButton addQs;
   private JButton takeQuiz;
   private JButton quit;
   private CardLayout cardLayout;
   private JPanel addQ;
   private JPanel pnlButtons2;
   private JButton add;
   private JButton writeAll;
   private JButton done;
   private JButton quit2;

   public BookQuizGUI() {
      f = new JFrame();
      f.setTitle("Book Quiz");
      // f.setSize(800, 400);
      f.setLocation(400, 250);
      f.setDefaultCloseOperation(EXIT_ON_CLOSE);
      contentPane = (JPanel) f.getContentPane();
      home = new JPanel();
      pnlButtons = new JPanel();
      pnlButtons.setLayout(new GridLayout(1, 3));
      addQs = new JButton("Add Questions");
      takeQuiz = new JButton("Take Quiz");
      quit = new JButton("Quit");
      pnlButtons.add(addQs);
      pnlButtons.add(takeQuiz);
      pnlButtons.add(quit);
      home.add(pnlButtons);

      addQ = new JPanel();
      addQ.setLayout(new GridLayout(1, 2));
      pnlButtons2 = new JPanel();
      add = new JButton("Add");
      writeAll = new JButton("Write All");
      done = new JButton("Done");
      quit2 = new JButton("Quit");
      pnlButtons2.add(add);
      pnlButtons2.add(writeAll);
      pnlButtons2.add(done);
      pnlButtons2.add(quit2);
      addQ.add(pnlButtons2, BorderLayout.SOUTH);

      addQs.addActionListener(this);
      takeQuiz.addActionListener(this);
      quit.addActionListener(this);


      card = new JPanel();
      cardLayout = new CardLayout();
      card.setLayout(cardLayout);
      card.add(home, HOME);
      card.add(addQ, ADD_Q);     
      cardLayout.show(card, HOME);
      f.add(card);
      f.pack();
      f.setVisible(true);
   }

   public static void main(String[] args) {
      new BookQuizGUI();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == quit) {
         System.exit(0);
      }
      if (e.getSource() == addQs) {
         cardLayout.show(card, ADD_Q);
      }
   }

}