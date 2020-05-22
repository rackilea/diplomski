public class Test {

    // Setup test scenario
    public Test() {

        // Create window
        JFrame f = new JFrame();
        f.setLayout(new BorderLayout());
        f.setSize(800, 600);
        f.setTitle("Inspector");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Create panel which will be used for the inspector
        JPanel p = new JPanel();

        // Encapsulate it to the scroll panel so it can grow vertically
        JScrollPane sp = new JScrollPane();
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setViewportView(p);

        // Create the inspector inside panel p
        Inspector inspector = new Inspector(p);

        // Fill the inspector with some test data
        int n = 2;
        for (int i = 0; i < n; ++i) {
            inspector.addTitle("Title");
            inspector.addButton("push me");
            inspector.addCheckBox("check me");
            inspector.addSpinner("Spin me");
            inspector.addTextField("Edit me", "here");
            inspector.addComboBox("Choose one", new String[]{"A", "B", "C"});
        }

        // The inspector will be on the right side of the window
        f.getContentPane().add(sp, BorderLayout.LINE_END);

        // Show the window
        f.setVisible(true);
    }

    // Main method
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }

    // Inspector class itself
    private class Inspector {

        private final JPanel panel;
        private final GridBagConstraints constraints;
        private int itemsCount = 0;

        public Inspector(JPanel p) {
            panel = new JPanel();
            p.add(panel);
            panel.setLayout(new GridBagLayout());

            constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 1.0;
        }

        // Adds component which will span across whole row
        private void addComponent(Component component) {
            constraints.gridx = 0;
            constraints.gridwidth = 2;
            constraints.gridy = itemsCount;

            panel.add(component, constraints);

            itemsCount++;
        }

        // Adds descriptive label on the left and component on the right side of the row
        private void addNamedComponent(String description, Component component) {
            constraints.gridx = 0;
            constraints.gridy = itemsCount;
            constraints.gridwidth = 1;
            panel.add(new JLabel(description), constraints);

            constraints.gridx = 1;
            constraints.gridy = itemsCount;
            constraints.gridwidth = 1;
            panel.add(component, constraints);

            itemsCount++;
        }

        public void addSeparator() {
            // (little hacky)
            addComponent(new JPanel());
        }

        public void addTitle(String title) {
            addComponent(new JLabel(title));
        }

        public void addButton(String actionName) {
            addComponent(new Button(actionName));
        }

        public void addCheckBox(String description) {
            addNamedComponent(description, new JCheckBox());
        }

        public void addSpinner(String description) {
            addNamedComponent(description, new JSpinner());
        }

        public void addTextField(String description, String text) {
            addNamedComponent(description, new JTextField(text));
        }

        public void addComboBox(String description, String[] options) {
            JComboBox<String> comboBox = new JComboBox<>();
            ComboBoxModel<String> model = new DefaultComboBoxModel<>(options);
            comboBox.setModel(model);

            addNamedComponent(description, comboBox);
        }

        public void finish() {
            constraints.gridx = 0;
            constraints.gridy = itemsCount;
            constraints.gridwidth = 2;
            constraints.weighty = 1.0;

            panel.add(new JPanel(), constraints);
        }
    }
}