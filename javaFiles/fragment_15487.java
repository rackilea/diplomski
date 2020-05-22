import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

public class FaceLayout extends JFrame {

    public FaceLayout() {

        ImageIcon face = new ImageIcon(getClass().getResource("/marioblobs/bowser.png"));
        ImageIcon eyes = new ImageIcon(getClass().getResource("/marioblobs/mario.png"));
        ImageIcon nose = new ImageIcon(getClass().getResource("/marioblobs/luigi.png"));
        ImageIcon mouth = new ImageIcon(getClass().getResource("/marioblobs/koopa.png"));

        JLabel fLab = new JLabel(face);
        fLab.setBounds(25, 25, 100, 100);
        JLabel eLab = new JLabel(eyes);
        eLab.setBounds(100, 100, 100, 100);
        JLabel nLab = new JLabel(nose);
        nLab.setBounds(175, 175, 100, 100);
        JLabel mLab = new JLabel(mouth);
        mLab.setBounds(250, 250, 100, 100);

        JCheckBox eBox = new JCheckBox("Eyes", false);
        JCheckBox nBox = new JCheckBox("Nose", false);
        JCheckBox mBox = new JCheckBox("Mouth", false);

        JButton submit = new JButton("Submit");

        JPanel leftPanel = new JPanel(new GridLayout(4, 1));
        leftPanel.add(eBox);
        leftPanel.add(nBox);
        leftPanel.add(mBox);
        leftPanel.add(submit);

        JLayeredPane layers = new JLayeredPane();

        layers.add(fLab, new Integer(1));
        layers.add(eLab, new Integer(2));
        layers.add(nLab, new Integer(3));
        layers.add(mLab, new Integer(4));

        JPanel rightPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 400);
            }
        };
        rightPanel.setLayout(null);
        layers.setBounds(0, 0, 400, 400);
        rightPanel.add(layers);

        JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        pane.setDividerLocation(150);

        Dimension lSize = new Dimension(100, 50);
        Dimension rSize = new Dimension(100, 400);
        leftPanel.setMinimumSize(lSize);
        rightPanel.setMinimumSize(rSize);

        add(pane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new FaceLayout();
            }
        });
    }
}