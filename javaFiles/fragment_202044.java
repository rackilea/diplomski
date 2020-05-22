public class MyCustomTabbedPane extends JTabbedPane {

    private final JPanel defaultTab = new JPanel();

    public MyCustomTabbedPane() {
        super();

        JButton exampleButton = new JButton("Click me");
        exampleButton.addActionListener((e) -> addTab("New page", null, new JPanel()));
        defaultTab.add(exampleButton);

        addTab("Default", null, defaultTab);
        addContainerListener(new ContainerListener() {

            @Override
            public void componentRemoved(ContainerEvent e) {
                if (getTabCount() == 0) {
                    addTab("Default", null, defaultTab);
                }
            }

            @Override
            public void componentAdded(ContainerEvent e) {
                if (getTabCount() > 1) {
                    remove(defaultTab);
                }
            }
        });
    }

    @Override
    public void addTab(String title, Icon icon, Component component) {
        // Add new tab at the back with default header
        super.addTab(title, icon, component);
        // Create custom header based on default header
        Component header = createHeader(title, icon, getTabComponentAt(indexOfComponent(component)));
        // Set header for previously added tab
        setTabComponentAt(indexOfComponent(component), header);
        // Select the added tab
        setSelectedComponent(component);
    }

    private Component createHeader(String title, Icon icon, Component header) {
        if(header == null) {
            header = new JLabel(title, icon, SwingConstants.LEFT);
        }
        JPanel panel = new JPanel();
        panel.add(new JLabel("Just an example header modification - "));
        panel.add(header);
        return panel;
    }
}