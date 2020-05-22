import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestSort {

    public static void main(String[] args) {
        new TestSort();
    }

    public TestSort() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                SortPane sortPane = new SortPane();
                int values[] = new int[10];
                for (int index = 0; index < values.length; index++) {
                    values[index] = (int)Math.round(Math.random() * 100f);
                }
                BubbleSort sorter = new BubbleSort(values);
                sortPane.setSorter(sorter);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(sortPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                sorter.sort();
            }
        });
    }

    public class SortPane extends JPanel {

        private Sorter sorter;
        private ChangeHandler changeHandler;
        private int maxValue;

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int values[] = getSorter().getValues();
            int width = getWidth() - 1;
            int height = getHeight() - 1;
            int colWidth = Math.round((float)width / (float)values.length);
            int x = 0;
            Color fill = Color.YELLOW;
            Color highlight = null;
            switch (getSorter().getState()) {
                case Sorting:
                    fill = Color.BLUE;
                    highlight = Color.RED;
                    break;
                case Done:
                    fill = Color.GREEN;
                    break;
            }
            for (int index = 0; index < values.length; index++) {
                g2d.setColor(fill);
                int value = values[index];
                int colHeight = (int)((float)height * ((float)value / (float)maxValue));
                g2d.fillRect(x, height - colHeight, colWidth - 1, colHeight);
                if (getSorter().isActiveIndex(index) && highlight != null) {
                    g2d.setColor(highlight);
                    g2d.drawRect(x, height - colHeight, colWidth - 1, colHeight);
                }
                x += colWidth;
            }
            g2d.dispose();
        }

        public Sorter getSorter() {
            return sorter;
        }

        public void setSorter(Sorter value) {
            if (sorter != value) {
                if (sorter != null) {
                    sorter.removeChangeListener(getChangeHandler());
                }
                sorter = value;
                if (sorter != null) {
                    sorter.addChangeListener(getChangeHandler());
                    maxValue = 0;
                    for (int intValue : sorter.getValues()) {
                        maxValue = Math.max(maxValue, intValue);
                    }
                }
                repaint();
            }
        }

        public ChangeHandler getChangeHandler() {
            if (changeHandler == null) {
                changeHandler = new ChangeHandler();
            }
            return changeHandler;
        }

        public class ChangeHandler implements ChangeListener {
            @Override
            public void stateChanged(ChangeEvent e) {
                repaint();
            }
        }

    }

    public interface Sorter {

        public enum State {
            Waiting,
            Sorting,
            Done
        }

        public void addChangeListener(ChangeListener listener);
        public void removeChangeListener(ChangeListener listener);
        public int[] getValues();
        public void sort();
        public State getState();
        public boolean isActiveIndex(int index);
    }

    public abstract class AbstracSorter implements Sorter {

        private List<ChangeListener> listeners;
        private int[] values;
        private State state = State.Waiting;
        private List<Integer> activeIndices;

        public AbstracSorter(int[] values) {
            this.values = values;
            listeners = new ArrayList<>(25);
            activeIndices = new ArrayList<>(2);
        }

        @Override
        public State getState() {
            return state;
        }

        public void setState(State value) {
            if (value != state) {
                state = value;
                fireStateChanged();
            }
        }

        @Override
        public int[] getValues() {
            return values;
        }

        @Override
        public void addChangeListener(ChangeListener listener) {
            listeners.add(listener);
        }

        @Override
        public void removeChangeListener(ChangeListener listener) {
            listeners.remove(listener);
        }

        protected void fireStateChanged() {
            if (listeners.size() > 0) {
                ChangeEvent evt = new ChangeEvent(this);
                for (ChangeListener listener : listeners) {
                    listener.stateChanged(evt);
                }
            }
        }

        @Override
        public boolean isActiveIndex(int index) {
            return activeIndices.contains(index);
        }

        protected void setActiveIndicies(int lower, int upper) {
            activeIndices.clear();
            activeIndices.add(lower);
            activeIndices.add(upper);
            fireStateChanged();
        }

        protected void swap(int[] anArrayOfInt, int i, int j) {
            setActiveIndicies(i, j);
            int x = anArrayOfInt[i];
            anArrayOfInt[i] = anArrayOfInt[j];
            anArrayOfInt[j] = x;
            fireStateChanged();
        }
    }

    public class BubbleSort extends AbstracSorter {

        private int outter = 0;
        private int inner = 0;

        public BubbleSort(int[] values) {
            super(values);
        }

        @Override
        public void sort() {
            setState(State.Sorting);
            outter = 0;
            inner = 1;
            Timer timer = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int[] values = getValues();
                    inner++;
                    if (inner >= values.length - outter) {
                        outter++;
                        inner = 1;
                    }

                    if (outter < values.length) {
                        if (values[inner - 1] > values[inner]) {
                            swap(values, inner - 1, inner);
                        } else {
                            setActiveIndicies(inner - 1, inner);
                        }
                    } else {
                        ((Timer)e.getSource()).stop();
                        setState(State.Done);
                    }
                }
            });
            timer.setRepeats(true);
            timer.start();
        }
    }
}