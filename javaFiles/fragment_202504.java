public class NestedLayoutManagersExample extends JFrame {
    private static final long serialVersionUID = -7042997375941726246L;
    private static final int labelsWidth = 80;
    private static final int textFieldColumns = 15;
    private static final int spaceBetweenAllComponents = 10;

    public NestedLayoutManagersExample() {
        super("test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel(new GridLayout(1, 2, 50, 50));
        contentPane.setBorder(BorderFactory.createEmptyBorder(spaceBetweenAllComponents, spaceBetweenAllComponents,
                spaceBetweenAllComponents, spaceBetweenAllComponents));
        setContentPane(contentPane);

        add(createLeftPanel());
        add(createRightPanel());

        setLocationByPlatform(true);
        pack();
    }

    private Component createRightPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel productListLabel = new JLabel("Product list");
        mainPanel.add(productListLabel, BorderLayout.PAGE_START);

        JList<String> productList = new JList<>();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        Arrays.asList("Small Chair", "Big Chair", "Flying Chair").forEach(listModel::addElement);
        productList.setModel(listModel);

        JScrollPane listScrollPane = new JScrollPane(productList);
        mainPanel.add(listScrollPane, BorderLayout.CENTER);
        return mainPanel;
    }

    private Component createLeftPanel() {

        JPanel mainPanel = new JPanel(new BorderLayout(spaceBetweenAllComponents, spaceBetweenAllComponents));

        JPanel topPanel = new JPanel(new GridLayout(2, 1, spaceBetweenAllComponents, spaceBetweenAllComponents));
        topPanel.add(createStraightPanel("Product Name"));
        topPanel.add(createStraightPanel("Amount"));
        mainPanel.add(topPanel, BorderLayout.PAGE_START);

        JPanel centerPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("<html><p style='width:" + labelsWidth + "px';> Description");
        label.setVerticalAlignment(JLabel.TOP);
        centerPanel.add(label, BorderLayout.LINE_START);

        centerPanel.add(createTextAreaPanel());

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        return mainPanel;
    }

    private JPanel createTextAreaPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout(spaceBetweenAllComponents, spaceBetweenAllComponents));

        JTextArea textArea = new JTextArea(1, textFieldColumns);

        JScrollPane textAreaScrollPane = new JScrollPane(textArea);
        mainPanel.add(textAreaScrollPane, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new BorderLayout());

        JButton addButton = new JButton("Add");
        buttonsPanel.add(addButton, BorderLayout.LINE_START);

        JButton removeButton = new JButton("Remove");
        buttonsPanel.add(removeButton, BorderLayout.LINE_END);

        mainPanel.add(buttonsPanel, BorderLayout.PAGE_END);
        return mainPanel;
    }

    private Component createStraightPanel(String labelText) {
        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("<html><p style='width:" + labelsWidth + "px';>" + labelText);
        mainPanel.add(label, BorderLayout.LINE_START);

        JTextField textField = new JTextField(textFieldColumns);

        mainPanel.add(textField, BorderLayout.CENTER);
        return mainPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NestedLayoutManagersExample().setVisible(true));
    }
}