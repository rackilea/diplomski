import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PRINCIPAL extends Level1 {
    JFrame MainWindow;
    JPanel panelCont;
    Pan1 Pan1Window;
    Pan2 Pan2Window;
    CardLayout cards;

    public PRINCIPAL() {
        MainWindow = new JFrame("Game Window");
        panelCont = new JPanel();
        cards = new CardLayout();
        Pan1Window = new Pan1(cards, panelCont, Level1Completed);
        Pan2Window = new Pan2(Pan1Window, cards, panelCont, Level1Completed);

        panelCont.setLayout(cards);
        panelCont.add(Pan1Window, "1");
        panelCont.add(Pan2Window, "2");
        cards.show(panelCont, "1");

        MainWindow.add(panelCont);
        MainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MainWindow.setSize(800, 800);
        MainWindow.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PRINCIPAL();
            }
        });
        }
    }

    class Level1 extends JPanel {

    static int Level1Completed = 0;

    public void setLevel1Completed(int newLevel1Completed) {
        Level1Completed = newLevel1Completed;
    }

    public int getLevel1Completed() {
        return Level1Completed;
    }
    }

    class Pan1 extends Level1 implements ComponentListener {
    JPanel panelCont;
    CardLayout LayoutPan1;
    JLabel label;
    JButton OpenPan2;
    JButton buttonLevel2;
    int L1Completed;

    public Pan1(final CardLayout LayoutPan1, final JPanel panelCont,
            final int Level1Completed) {
        this.L1Completed = super.getLevel1Completed();
        this.panelCont = panelCont;
        this.LayoutPan1 = LayoutPan1;
        addComponentListener(this);

        OpenPan2 = new JButton("Open Pan2 Window");
        buttonLevel2 = new JButton("Progress to Level 2");
        OpenPan2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent GoToPan2) {
                if (GoToPan2.getSource() == OpenPan2) {
                    LayoutPan1.show(panelCont, "2");
                }
            }
        });
        add(OpenPan2);

        // this printout is to see that, at the beginning, the Level1 variable
        // is set to 0 (see the command line)
        System.out.println(getLevel1Completed());

        setBackground(Color.GREEN);
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void componentMoved(ComponentEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void componentResized(ComponentEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void componentShown(ComponentEvent e) {
        // this is where the problem is: what I want is that this button is
        // initially not visible as the variable is set to 0
        // but when, in the next pan, I'll set it to 1, this button becomes
        // visible
        if (super.getLevel1Completed() == 1) {
            add(buttonLevel2);
            buttonLevel2.setVisible(true);
            invalidate();
            revalidate();
        }
    }
    }

    class Pan2 extends Level1 {
    JPanel Pan1Window;
    CardLayout LayoutPan1Window;
    JPanel panelCont;
    JButton OpenPan1;
    JButton L1Done;
    int L1Completed;

    public Pan2(final JPanel Pan1Window, final CardLayout LayoutPan1Window,
            final JPanel panelCont, final int L1Completed) {
        this.L1Completed = super.getLevel1Completed();
        OpenPan1 = new JButton("Go back to Pan 1");
        OpenPan1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ApriFinestraLancio) {
                if (ApriFinestraLancio.getSource() == OpenPan1) {
                    LayoutPan1Window.show(panelCont, "1");
                }
            }
        });
        add(OpenPan1);

        L1Done = new JButton("Set Level 1 as Completed");
        L1Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent SettaL1Complet) {
                setLevel1Completed(1);
                System.out.println(getLevel1Completed());// this print shows
                                                            // that the value of
                                                            // the variable is
                                                            // correctly changed
                                                            // to 1
            }
        });
        add(L1Done);

        setBackground(Color.RED);
    }
    }