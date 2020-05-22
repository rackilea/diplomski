public class ChangeButtonColor implements Runnable {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Cannot set LookAndFeel");
        }
        SwingUtilities.invokeLater(new ChangeButtonColor());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());

        JButton button1 = new JButton("click me");
        JButton button2 = new JButton("click me too");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source instanceof Component) {
                    ((Component)source).setBackground(Color.RED);
                }
            }
        };
        button1.addActionListener(listener);
        button2.addActionListener(listener);

        frame.add(button1);
        frame.add(button2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}