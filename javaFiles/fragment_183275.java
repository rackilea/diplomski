import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FrameState extends JFrame {
    private static final long serialVersionUID = 1965751967944243251L;
    private int state = -1; // Variable to keep the last state.

    public FrameState() {
        super("Nothing :)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton b = new JButton("-");
        b.addActionListener(e -> {
            state = getExtendedState(); //Store the state before "-" is pressed
            setExtendedState(JFrame.ICONIFIED);
        });
        JButton o = new JButton("O");
        o.addActionListener(e -> {
            if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                setExtendedState(JFrame.NORMAL);
            } else {
                setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(o);
        getContentPane().add(b);
        setSize(new Dimension(300, 300));
        setLocationRelativeTo(null);
        addComponentListener(new ComponentListener() {

            @Override
            public void componentShown(ComponentEvent arg0) {
            }

            @Override
            public void componentResized(ComponentEvent arg0) {
                if (state != -1) {
                    setExtendedState(state); //Restore the state.
                    state = -1; //If it is not back to -1, window won't be resized properly by OS.
                }
            }

            @Override
            public void componentMoved(ComponentEvent arg0) {
            }

            @Override
            public void componentHidden(ComponentEvent arg0) {
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FrameState f = new FrameState();
            f.setVisible(true);
        });
    }
}