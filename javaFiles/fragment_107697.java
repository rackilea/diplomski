import java.awt.FlowLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.Icon;
    import javax.swing.ImageIcon;
    import javax.swing.JButton;
    import javax.swing.JFrame;

    public class BGUI extends JFrame {
private JButton pine;
private JButton rock;
private int pineappleCount = 0,
        rockCount = 0;

public BGUI(){
    super("Bikini Bottom Builder Game");
    setLayout(new FlowLayout());
    setSize(800, 800);

    Icon p = new ImageIcon(getClass().getResource("b.png"));
    pine = new JButton("Add Pineapple: " + pineappleCount, p);
    pine.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            pine.setText("Add Pineapple: " + ++pineappleCount);
        }

    });
    add(pine);

    Icon r = new ImageIcon(getClass().getResource("b.png"));
    rock = new JButton("Add Rock: " + rockCount, r);
    rock.setRolloverIcon(r);
    rock.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            rock.setText("Add Rock: " + ++rockCount);
        }

    });
    add(rock);

    super.setVisible(true);

}


public static void main(String[] a) {
    new BGUI();
}
    }