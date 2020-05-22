import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class TextDemo extends JPanel implements ActionListener {

    private static JFrame frame;

    public TextDemo() {
        super(new GridBagLayout());
        JComboBox correct = new JComboBox(new String[]{"One", "Two", "Three"});
        JComboBox alsoCorrect = new JComboBox(new String[]{"One", "Two", "Three"});
        alsoCorrect.setRenderer(new MyRenderer());
        JComboBox incorrect = new JComboBox(new String[]{"One", "Two", "Three"});
        incorrect.setRenderer(new NotWorkingRenderer());
        JButton button = new JButton("Change LnF");
        button.addActionListener(this);
        add(incorrect, getConstraints(0));
        add(correct, getConstraints(1));
        add(alsoCorrect, getConstraints(2));
        add(button, getConstraints(3));
    }

    private GridBagConstraints getConstraints(int y) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = y;
        c.insets = new Insets(4, 8, 4, 8);
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        return c;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void createAndShowGUI() {
        frame = new JFrame("TextDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TextDemo());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            //SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

class MyRenderer implements ListCellRenderer {

    protected static ListCellRenderer delegate;

    static {
        refreshRenderers();
        UIManager.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("lookAndFeel")) {
                    refreshRenderers();
                }
            }
        });
    }

    protected static void refreshRenderers() {
        delegate = new JComboBox().getRenderer();
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        return delegate.getListCellRendererComponent(list, value,
                index, isSelected, cellHasFocus);
    }
}

class NotWorkingRenderer extends MyRenderer {

    private JPanel panel = new JPanel();

    public NotWorkingRenderer() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        c.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
        panel.add(c);
        return panel;
    }
}