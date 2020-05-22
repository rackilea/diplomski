public static void main(String[] args)
{
    JFrame contentPane = new JFrame();
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new BorderLayout());

    JLabel label = new JLabel("This should be centered");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    centerPanel.add(label, BorderLayout.CENTER);

    contentPane.add(centerPanel, BorderLayout.CENTER);
    contentPane.pack();
    contentPane.setVisible(true);
}