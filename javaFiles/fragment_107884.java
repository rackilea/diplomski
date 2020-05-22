import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.MatteBorder;

public class TestLayout {

    public static void main(String[] args) {
        new TestLayout();
    }

    public TestLayout() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(4, 0, 4, 0);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1;

            add(new JLabel("Big binds of first level: 25/50", JLabel.CENTER), gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            SelectionPane selectionPane = new SelectionPane();
            selectionPane.setBorder(new MatteBorder(1, 0, 0, 0, Color.BLACK));
            add(selectionPane, gbc);

            gbc.gridx++;
            FilterPane filterPane = new FilterPane();
            filterPane.setBorder(new MatteBorder(1, 1, 0, 0, Color.BLACK));
            add(filterPane, gbc);

            selectionPane.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    filterPane.setOptions(selectionPane.getSelectedValues());
                }
            });
        }

    }

    protected class SelectionPane extends JPanel {

        private JList<Integer> listValues;
        private DefaultListModel<Integer> listModel;

        public SelectionPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.weightx = 1;
            add(new JLabel("Add bind numbers to queries"), gbc);

            gbc.weighty = 1;
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.BOTH;
            listModel = new DefaultListModel();
            for (int index = 0; index < 100; index++) {
                listModel.addElement(index);
            }
            listValues = new JList(listModel);
            add(new JScrollPane(listValues), gbc);

            gbc.weighty = 0;
            gbc.weightx = 0;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.gridx++;
            gbc.fill = GridBagConstraints.NONE;
            gbc.ipadx = 10;
            gbc.ipady = 10;
            JButton add = new JButton("Add");
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireActionPerformed();
                }
            });
            add(add, gbc);
        }

        public List<Integer> getSelectedValues() {

            return Collections.unmodifiableList(listValues.getSelectedValuesList());

        }

        public void addActionListener(ActionListener listener) {
            listenerList.add(ActionListener.class, listener);
        }

        public void removeActionListener(ActionListener listener) {
            listenerList.remove(ActionListener.class, listener);
        }

        protected void fireActionPerformed() {
            ActionListener[] listeners = listenerList.getListeners(ActionListener.class);
            if (listeners.length > 0) {
                ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Selection.add");
                for (ActionListener listener : listeners) {
                    listener.actionPerformed(evt);
                }
            }
        }

    }

    protected class FilterPane extends JPanel {

        private OptionsPane optionsPane;

        public FilterPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.weightx = 1;
            add(new JLabel("Remove big blind numbers"), gbc);

            gbc.weighty = 1;
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 1;
            gbc.gridheight = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.BOTH;
            optionsPane = new OptionsPane();
            add(new JScrollPane(optionsPane), gbc);

            gbc.weighty = 0;
            gbc.gridheight = 1;
            gbc.weightx = 0;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.gridx++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.ipadx = 10;
            gbc.ipady = 10;
            JButton remove = new JButton("Remove");
            add(remove, gbc);

            gbc.gridy++;
            JButton removeAll = new JButton("Remove All");
            add(removeAll, gbc);
        }

        public void setOptions(List<Integer> options) {
            optionsPane.setOptions(options);
        }

        protected class OptionsPane extends JPanel implements Scrollable {

            public OptionsPane() {
                setLayout(new GridBagLayout());
            }

            public void setOptions(List<Integer> options) {
                removeAll();
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 1;
                gbc.anchor = GridBagConstraints.WEST;
                for (Integer option : options) {
                    JCheckBox cb = new JCheckBox(option.toString());
                    add(cb, gbc);
                    gbc.gridx++;
                    if (gbc.gridx % 5 == 0) {
                        gbc.gridx = 0;
                        gbc.gridy++;
                    }
                }

                gbc.gridx = 0;
                gbc.gridy++;
                gbc.weighty = 1;
                add(new JLabel(), gbc);

                revalidate();
                repaint();
            }

            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(210, 100);
            }

            @Override
            public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
                return 64;
            }

            @Override
            public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
                return 64;
            }

            @Override
            public boolean getScrollableTracksViewportWidth() {
                return getPreferredSize().width
                        <= getParent().getSize().width;
            }

            @Override
            public boolean getScrollableTracksViewportHeight() {
                return getPreferredSize().height
                        <= getParent().getSize().height;
            }

        }

    }

}