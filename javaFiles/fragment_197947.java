import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class TestLaf {

    protected void initUI() {
        final JFrame frame = new JFrame(TestLaf.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JComboBox<LookAndFeelInfo> laf = new JComboBox<LookAndFeelInfo>();
        LookAndFeelInfo selected = null;
        for (LookAndFeelInfo lafInfo : UIManager.getInstalledLookAndFeels()) {
            laf.addItem(lafInfo);
            if (lafInfo.getName().equals(UIManager.getLookAndFeel().getName())) {
                selected = lafInfo;
            }
        }
        laf.setSelectedItem(selected);
        laf.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value != null) {
                    LookAndFeelInfo lafInfo = (LookAndFeelInfo) value;
                    setText(lafInfo.getName());
                } else {
                    setText("");
                }
                return this;
            }
        });
        laf.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String className = laf.getModel().getElementAt(laf.getSelectedIndex()).getClassName();
                System.err.println("Changing to " + className);
                try {
                    UIManager.setLookAndFeel(className);
                    SwingUtilities.updateComponentTreeUI(frame.getRootPane());
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (InstantiationException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                }
            }
        });
        frame.add(laf);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestLaf().initUI();
            }
        });
    }
}