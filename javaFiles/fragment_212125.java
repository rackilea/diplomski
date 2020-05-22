import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class LafDemo {

    public static void changeLaf(JFrame frame, String laf) {
        if (laf.equals("metal")) {
            try {
                UIManager.setLookAndFeel(UIManager
                        .getCrossPlatformLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException
                    | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        }
        if (laf.equals("nimbus")) {
            try {
                UIManager
                        .setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (ClassNotFoundException | InstantiationException
                    | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        }
        if (laf.equals("system")) {
            try {
                UIManager.setLookAndFeel(UIManager
                        .getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException
                    | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        }

        SwingUtilities.updateComponentTreeUI(frame);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                final JFrame frame = new JFrame();
                JPanel panel = new JPanel();
                JButton btnDemo = new JButton("JButton");
                JSpinner spnDemo = new JSpinner();
                JComboBox<String> cmbDemo = new JComboBox<String>();
                cmbDemo.addItem("One");
                cmbDemo.addItem("Two");
                cmbDemo.addItem("Three");

                JMenuBar mBar = new JMenuBar();
                frame.setJMenuBar(mBar);
                JMenu mnuLaf = new JMenu("Look and feel");
                JRadioButtonMenuItem mniNimbus = new JRadioButtonMenuItem(
                        "Nimbus");
                JRadioButtonMenuItem mniMetal = new JRadioButtonMenuItem(
                        "Metal");
                JRadioButtonMenuItem mniSystem = new JRadioButtonMenuItem(
                        "Systems");

                ButtonGroup btnGroup = new ButtonGroup();
                btnGroup.add(mniNimbus);
                btnGroup.add(mniMetal);
                btnGroup.add(mniSystem);
                mBar.add(mnuLaf);
                mnuLaf.add(mniNimbus);
                mnuLaf.add(mniMetal);
                mnuLaf.add(mniSystem);

                mniNimbus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        changeLaf(frame, "nimbus");
                    }
                });
                mniMetal.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        changeLaf(frame, "metal");
                    }
                });
                mniSystem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        changeLaf(frame, "system");
                    }
                });

                DefaultTableModel model = new DefaultTableModel(
                        new Object[][] {}, new String[] { "First", "Second" });
                model.addRow(new Object[] { "Some text", "Another text" });
                JTable table = new JTable(model);
                panel.add(btnDemo);
                panel.add(spnDemo);
                panel.add(cmbDemo);
                frame.add(panel, BorderLayout.NORTH);
                frame.add(new JScrollPane(table), BorderLayout.CENTER);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
    }
}