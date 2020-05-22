public class ComboWithPrototype {

    private JComponent createContent() {
        final Font[] systemFonts = GraphicsEnvironment
                .getLocalGraphicsEnvironment().getAllFonts();

        final JComboBox box = new JComboBox();
        box.setRenderer(new ComboBoxRenderer());
        box.setPrototypeDisplayValue(systemFonts[0]);
        Accessible a = box.getUI().getAccessibleChild(box, 0);
        if (a instanceof javax.swing.plaf.basic.ComboPopup) {
            JList popupList = ((javax.swing.plaf.basic.ComboPopup) a).getList();
            // route the comboBox' prototype to the list
            // should happen in BasicComboxBoxUI
            popupList.setPrototypeCellValue(box.getPrototypeDisplayValue());
        }
        Action action = new AbstractAction("set model") {

            @Override
            public void actionPerformed(ActionEvent e) {
                box.setModel(new DefaultComboBoxModel(systemFonts));
            }
        };
        JComponent panel = new JPanel(new BorderLayout());
        panel.add(box);
        panel.add(new JButton(action), BorderLayout.SOUTH);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new ComboWithPrototype().createContent());
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }