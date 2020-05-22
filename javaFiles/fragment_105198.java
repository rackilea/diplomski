import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class TestSegmentDisplay {

    public static void main(String[] args) {
        new TestSegmentDisplay();
    }

    private SegmentDisplay segmentDisplay;
    private int count = 0;

    public TestSegmentDisplay() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                segmentDisplay = new SegmentDisplay();

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(segmentDisplay);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                final Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setSegmentValue(segmentDisplay, count);
                        count++;
                        if (count > 9) {
                            count = 0;
                        }
                    }
                });
                timer.start();

            }
        });
    }

    public static void setSegmentValue(SegmentDisplay display, int value) {

        boolean[] states = new boolean[]{
            false,
            false, false,
            false,
            false, false,
            false
        };
        switch (value) {
            case 0:
                states = new boolean[]{
                    true,
                    true, true,
                    false,
                    true, true,
                    true};
                break;
            case 1:
                states = new boolean[]{
                    false,
                    false, true,
                    false,
                    false, true,
                    false};
                break;
            case 2:
                states = new boolean[]{
                    true,
                    false, true,
                    true,
                    true, false,
                    true};
                break;
            case 3:
                states = new boolean[]{
                    true,
                    false, true,
                    true,
                    false, true,
                    true};
                break;
            case 4:
                states = new boolean[]{
                    false,
                    true, true,
                    true,
                    false, true,
                    false};
                break;
            case 5:
                states = new boolean[]{
                    true,
                    true, false,
                    true,
                    false, true,
                    true};
                break;
            case 6:
                states = new boolean[]{
                    true,
                    true, false,
                    true,
                    true, true,
                    true};
                break;
            case 7:
                states = new boolean[]{
                    true,
                    false, true,
                    false,
                    false, true,
                    false};
                break;
            case 8:
                states = new boolean[]{
                    true,
                    true, true,
                    true,
                    true, true,
                    true};
                break;
            case 9:
                states = new boolean[]{
                    true,
                    true, true,
                    true,
                    false, true,
                    true};
                break;
        }

        display.setSegments(states);

    }

    public static class SegmentDisplay extends JPanel {

        private Segement[] segemnts;

        public SegmentDisplay() {
            segemnts = new Segement[7];
            segemnts[0] = new Segement(Segement.Direction.HORIZONTAL);
            segemnts[1] = new Segement(Segement.Direction.VERTICAL);
            segemnts[2] = new Segement(Segement.Direction.VERTICAL);
            segemnts[3] = new Segement(Segement.Direction.HORIZONTAL);
            segemnts[4] = new Segement(Segement.Direction.VERTICAL);
            segemnts[5] = new Segement(Segement.Direction.VERTICAL);
            segemnts[6] = new Segement(Segement.Direction.HORIZONTAL);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            add(segemnts[0], gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            add(segemnts[1], gbc);
            gbc.gridx = 2;
            add(segemnts[2], gbc);

            gbc.gridx = 1;
            gbc.gridy++;
            add(segemnts[3], gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(segemnts[4], gbc);
            gbc.gridx = 2;
            add(segemnts[5], gbc);

            gbc.gridx = 1;
            gbc.gridy++;
            add(segemnts[6], gbc);
        }

        public void setSegments(boolean[] states) {

            if (states != null && states.length > 0 && states.length == segemnts.length) {

                for (int index = 0; index < segemnts.length; index++) {
                    segemnts[index].setOn(states[index]);
                }

            }

        }

    }

    public static class Segement extends JPanel {

        public enum Direction {

            VERTICAL,
            HORIZONTAL;
        }

        public static final int SMALL_SIZE = 10;
        public static final int LARGE_SIZE = SMALL_SIZE * 4;

        protected static final Color OUT_LINE = new Color(128, 0, 0);
        protected static final Color ON_COLOR = Color.RED;
        protected static final Color OFF_COLOR = new Color(64, 0, 0);

        private final Direction direction;
        private boolean on;

        public Segement(Direction direction) {
            this.direction = direction;
            setBorder(new LineBorder(OUT_LINE));
            setOn(true);
            setOn(false);
        }

        public void setOn(boolean value) {
            if (on != value) {
                on = value;
                if (on) {
                    setBackground(ON_COLOR);
                } else {
                    setBackground(OFF_COLOR);
                }
            }
        }

        public boolean isOn() {
            return on;
        }

        public Direction getDirection() {
            return direction;
        }

        @Override
        public Dimension getPreferredSize() {
            return getDirection() == Direction.VERTICAL ? new Dimension(SMALL_SIZE, LARGE_SIZE) : new Dimension(LARGE_SIZE, SMALL_SIZE);
        }

    }

}