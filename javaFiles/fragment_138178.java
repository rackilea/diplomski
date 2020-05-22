public class Test {

    public static void main(String [] args) throws IOException {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets.top = 5;
        gbc.insets.right = 5;

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridBagLayout());

        add(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, gbc, topPanel, createPanel());
        add(1, 0, 1, 1, 2, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, gbc, topPanel, createPanel());
        add(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, gbc, bottomPanel, createPanel());
        add(1, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, gbc, bottomPanel, createPanel());
        add(2, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, gbc, bottomPanel, createPanel());
        add(0, 2, 1, 1, 3, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, gbc, bottomPanel, createPanel());

        panel.add(topPanel);
        panel.add(bottomPanel);

        frame.setContentPane(panel);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private static void add(int gridx, int gridy, int weightx, int weighty, int gridw, int gridh, int fill, int anchor, GridBagConstraints gbc, Container container, JComponent component) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.gridwidth = gridw;
        gbc.gridheight = gridh;
        gbc.fill = fill;
        gbc.anchor = anchor;

        component.add(Box.createHorizontalStrut(5));
        component.add(new JLabel("(" + gridx + "; " + gridy + ")"));
        component.add(Box.createHorizontalStrut(5));
        component.add(new JLabel("gridwidth = " + gridw));
        component.add(Box.createHorizontalStrut(5));

        container.add(component, gbc);
    }

    private static JPanel createPanel() {
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.setBorder(BorderFactory.createLineBorder(Color.RED));

        return panel1;
    }
}