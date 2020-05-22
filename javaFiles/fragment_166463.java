public class CheckBoxInJList extends JFrame {
    private static final long serialVersionUID = -1662279563193298340L;

    public CheckBoxInJList() {
        super("test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DefaultListModel<String> model;
        JList<String> list = new JList<>(model = new DefaultListModel<>());
        for (int i = 0; i < 1000; i++) {
            String s = "String: " + i + ".";
            model.addElement(s);
        }
        list.setCellRenderer(new CheckBoxRenderer());

        add(new JScrollPane(list), BorderLayout.CENTER);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    private static class CheckBoxRenderer extends JCheckBox implements ListCellRenderer<String> {
        public CheckBoxRenderer() {
            super();
            setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
                boolean isSelected, boolean cellHasFocus) {
            setText(value);
            setSelected(isSelected);
            return this;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CheckBoxInJList().setVisible(true);
        });
    }
}