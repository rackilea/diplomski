public class Example extends JFrame {

    private JScrollPane pane;
    private int value;

    public Example() {
        final JTextArea jTextArea = new JTextArea(10, 10);

        final JTextArea jTextArea2 = new JTextArea(10, 10);
        jTextArea2.setText("1\n21\n2\n\n\n\n\n121221\ne\n\nee\ne\n");
        pane = new JScrollPane(jTextArea);
        JButton save = new JButton("save");
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                value = pane.getVerticalScrollBar().getValue();
            }
        });

        JButton load = new JButton("load");
        load.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                pane.getViewport().setView(jTextArea2);
                pane.getVerticalScrollBar().setValue(value);
            }
        });

        getContentPane().add(save,BorderLayout.WEST);
        getContentPane().add(pane,BorderLayout.CENTER);
        getContentPane().add(load,BorderLayout.EAST);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new Example().setVisible(true);
            }
        });
    }
}