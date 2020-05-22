public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            final DefaultListModel<String> model = new DefaultListModel<>();
            JList<String> list = new JList<>(model);

            JButton add = new JButton("Click Me!");
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.addElement(model.getSize() + "");
                }
            });

            JPanel p = new JPanel();
            p.add(new JScrollPane(list));
            p.add(add);

            JFrame frame = new JFrame("Example");
            frame.setContentPane(p);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    });
}