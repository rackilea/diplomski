public CombinedPanels() {
    setTitle("Auto Loan Calculator");
    setSize(700, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    JPanel center = new JPanel(new GridLayout(2, 2, 20, 20));

    // Add other classes to this layout
    PaymentInformation pi = new PaymentInformation();
    ActionButtons ab = new ActionButtons(pi);
    add(ab.getGUI(), BorderLayout.SOUTH);
    // Add center JPanel to the center of BorderLayout
    add(center, BorderLayout.CENTER);
    // Continue with adding rest of classes to center JPanel
    center.add(pi.getGUI());
    setVisible(true);
}