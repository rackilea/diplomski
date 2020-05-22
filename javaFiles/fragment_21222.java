static class TransparentJPanel extends JPanel {{
    setOpaque(false);
}}

public static void main(String... args) throws Exception {

    JFrame frame = new JFrame("Test");

    final JPanel panel;

    frame.add(panel = new JPanel() {{
        add(new TransparentJPanel());
        add(new TransparentJPanel());
        add(new TransparentJPanel());
    }}, BorderLayout.CENTER);

    frame.add(new JButton(new AbstractAction("Toggle") {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (panel.getBackground().equals(Color.RED))
                panel.setBackground(Color.GREEN);
            else
                panel.setBackground(Color.RED);
        }
    }), BorderLayout.SOUTH);


    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}