class Booter {

    void createUI() {
        CustomLabel customLabel = new CustomLabel("TEST TEXT");

        JPanel jPanel = new JPanel();
        JLabel label = new JLabel("Test2");
        jPanel.add(customLabel);
        jPanel.add(label);
    }
}