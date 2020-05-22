public static void main(String[] args)
{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel()
    {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 1000);
        }
    };
    panel.add(new JLabel("Test1"));
    panel.add(new JLabel("Test2"));
    frame.getContentPane().add(new JScrollPane(panel), BorderLayout.CENTER);
    frame.setSize(600, 800);
    frame.setVisible(true);
}