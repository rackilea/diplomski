import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MirroredFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private State state;
    private String name;
    private Set<StateListener> listeners = new HashSet<StateListener>();

    public MirroredFrame(String name) {
        super(name);
        final String frameName = name;
        this.name = frameName;
        state = new State();
        addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                state.setSize(getSize(), true);
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                System.out.println("JFrame : " + frameName + ", location on the screen " + getLocation());
            }

            @Override
            public void componentShown(ComponentEvent e) {
                System.out.println("JFrame : " + frameName + " shown ");
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                System.out.println("JFrame : " + frameName + " hidden ");
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addListener(StateListener sl) {
        listeners.add(sl);
    }

    public void associateWith(MirroredFrame other) {
        other.addListener(new MirrorStateListener());
    }

    private class State {

        private Dimension size;

        public void setSize(Dimension newSize, boolean fireEvent) {
            if (newSize.equals(size)) {
                return;
            }
            int height = newSize.height;
            int widht = newSize.width;
            if (height > widht) {
                size = new Dimension(height, height);
            } else {
                size = new Dimension(widht, widht);
            }
            MirroredFrame.this.setSize(size);
            if (fireEvent) {
                for (StateListener sl : listeners) {
                    sl.sizeChanged(size);
                }
            }
        }
    }

    private static interface StateListener {

        void sizeChanged(Dimension newSize);
    }

    private class MirrorStateListener implements StateListener {

        @Override
        public void sizeChanged(Dimension newSize) {
            System.out.println("JFrame : " + name + " received and changed sizeChanged Event");
            state.setSize(newSize, false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MirroredFrame f1 = new MirroredFrame("f1");
                MirroredFrame f2 = new MirroredFrame("f2");
                f1.associateWith(f2);
                f2.associateWith(f1);
                f1.setSize(300, 300);
                f2.setLocation(600, 10);
            }
        });
    }
}