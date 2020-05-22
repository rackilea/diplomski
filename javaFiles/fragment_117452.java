import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class TestKeyBind {
    public TestKeyBind() {
        JButton playButton = new JButton(play);
        JButton stopButton = new JButton(stop);
        JFrame frame = new JFrame();
        JPanel contentPane = (JPanel)frame.getContentPane();

        InputMap im = contentPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap am = contentPane.getActionMap();
        im.put(KeyStroke.getKeyStroke("P"), "play");
        am.put("play", play);
        im.put(KeyStroke.getKeyStroke("S"), "stop");
        am.put("stop", stop);

        frame.setLayout(new GridBagLayout());
        frame.add(playButton);
        frame.add(stopButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    Action play = new AbstractAction("Play") {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Play");
        }
    };
    Action stop = new AbstractAction("Stop") {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Stop");
        }
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new TestKeyBind();
            }
        });
    }
}