import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();

                final MainPanel myPanel = new MainPanel();
                f.add(myPanel);

                JButton button1 = new JButton("Show Animation A");
                JButton button2 = new JButton("Show Animation B");

                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        myPanel.setI(1);
                        System.out.println("The variable i is now: " + myPanel.i);
                        myPanel.refreshMe();
                    }
                });
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        myPanel.setI(2);
                        System.out.println("The variable i is now: " + myPanel.i);
                        myPanel.refreshMe();
                    }
                });

                myPanel.add(button1);
                myPanel.add(button2);
                myPanel.checkPanel();

                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                f.pack();
                f.setVisible(true);
            }
        });
    }
}

class MainPanel extends JPanel {

    Panel1 p1 = new Panel1();
    Panel2 p2 = new Panel2();
    public int i = 1;  //this is being changed later by clicking JButton
    // I use this setter later in actionPerformed in order to change i

    public void setI(int i) {
        this.i = i;
    }

    public void refreshMe() {
        checkPanel();

        revalidate();
        repaint();
        // Need some help here:
        // I don't know what should I write, how to make a repaint of myPanel?
        System.out.println("just test, if the method refreshMe working by clicking some button");
    }

    public void checkPanel() {
        if (i == 1) {
            this.add(p1);
            this.remove(p2);//or it will remain there as this is default flowlayout
        } else if (i == 2) {
            this.add(p2);
            this.remove(p1);
        }
    }
}

class Panel1 extends JPanel {

    public Panel1() {
        this.setBackground(Color.BLUE);
        // a lot of drawing stuff going on here
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}

class Panel2 extends JPanel {

    public Panel2() {
        this.setBackground(Color.GREEN);
        // a lot of drawing stuff going on here
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}