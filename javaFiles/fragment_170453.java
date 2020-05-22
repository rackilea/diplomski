import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class DynamicGridLayout {

    private JFrame f = new JFrame("Three Button/Text Field Combo");
    private JPanel ui = new JPanel(new GridBagLayout()) {
        @Override
        public Dimension getMinimumSize() {
            return new Dimension(400, 300);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 600);
        }

        @Override
        public Dimension getMaximumSize() {
            return new Dimension(800, 600);
        }
    };
    private JPanel controls = new JPanel() {
        @Override
        public Dimension getMinimumSize() {
            return new Dimension(400, 300);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 600);
        }

        @Override
        public Dimension getMaximumSize() {
            return new Dimension(1050, 720);
        }
    };
    private JCheckBox checkValidate, checkReValidate, checkRepaint, checkPack;

    DynamicGridLayout() {
        initUI();
    }

    public final void initUI() {
        ui.setBorder(new TitledBorder("Parent Panel"));
        ui.add(controls);
        controls.setBackground(Color.RED);
        controls.setBorder(new TitledBorder("Child Panel"));
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.add(ui);
        f.add(getCheckBoxPanel(), "South");
        f.setMinimumSize(ui.getPreferredSize());
        f.setVisible(true);
    }

    public JComponent getUI() {
        return ui;
    }

    private void addLabel() {
        JPanel controls1 = new JPanel(new GridLayout(3, 0, 3, 3));
        controls1.setBackground(Color.green);
        controls1.setBorder(new EmptyBorder(75, 75, 75, 75));
        controls.add(controls1);
    }

    private JPanel getCheckBoxPanel() {
        checkValidate = new JCheckBox("validate");
        checkValidate.setSelected(false);
        checkReValidate = new JCheckBox("revalidate");
        checkReValidate.setSelected(true);
        checkRepaint = new JCheckBox("repaint");
        checkRepaint.setSelected(true);
        checkPack = new JCheckBox("pack");
        checkPack.setSelected(false);
        JButton addComp = new JButton("Add New One");
        addComp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controls.getComponentCount() < 1) {
                    controls.setLayout(new BorderLayout());
                    addLabel();
                    makeChange();
                } else if (controls.getComponentCount() == 1) {
                    controls.setLayout(new GridLayout(0, 2, 10, 10));
                    addLabel();
                    makeChange();
                } else {
                    controls.setLayout(new GridLayout(2, 0, 10, 10));
                    addLabel();
                    makeChange();
                }
                System.out.println(" Components Count after Adds :" + controls.getComponentCount());
            }
        });
        JButton removeComp = new JButton("Remove One");
        removeComp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = controls.getComponentCount();
                if (count > 0) {
                    if (controls.getComponentCount() == 2) {
                        controls.setLayout(new BorderLayout());
                        controls.remove(0);
                    } else if (controls.getComponentCount() == 3) {
                        controls.setLayout(new GridLayout(0, 2, 10, 10));
                        controls.remove(0);
                    } else {
                        controls.remove(0);
                    }

                }
                makeChange();
                System.out.println(" Components Count after Removes :" + controls.getComponentCount());
            }
        });
        JPanel panel2 = new JPanel();
        panel2.add(checkValidate);
        panel2.add(checkReValidate);
        panel2.add(checkRepaint);
        panel2.add(checkPack);
        panel2.add(addComp);
        panel2.add(removeComp);
        return panel2;
    }

    private void makeChange() {
        if (checkValidate.isSelected()) {
            ui.validate();
        }
        if (checkReValidate.isSelected()) {
            ui.revalidate();
        }
        if (checkRepaint.isSelected()) {
            ui.repaint();
        }
        if (checkPack.isSelected()) {
            f.pack();
        }
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                DynamicGridLayout dgl = new DynamicGridLayout();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}