public static void main(String... args) {

    JFrame frame = new JFrame("Test");

    JList list = new JList(new String[] { 
            "Hello", "World!", "as", "we", "know", "it" });

    list.setCellRenderer(new ListCellRenderer() {

        @Override
        public Component getListCellRendererComponent(
                JList list, 
                Object value,
                int index, 
                boolean isSelected, 
                boolean cellHasFocus) {

            JPanel panel = new JPanel(new GridBagLayout());

            if (isSelected)
                panel.setBackground(Color.LIGHT_GRAY);

            panel.setBorder(BorderFactory.createMatteBorder(
                    index == 0 ? 1 : 0, 1, 1, 1, Color.BLACK));

            GridBagConstraints gbc = new GridBagConstraints();

            gbc.anchor = GridBagConstraints.EAST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(4,4,4,4);

            // index
            gbc.weightx = 0;
            panel.add(new JLabel("" + index), gbc);

            // "name"
            gbc.weightx = 1;
            panel.add(new JLabel("" + value), gbc);

            // cost
            gbc.weightx = 0;
            String cost = String.format("$%.2f", Math.random() * 100);
            panel.add(new JLabel(cost), gbc);


            return panel;
        }
    });

    frame.add(list);

    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}