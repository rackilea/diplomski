public class PanelRevalidate {
    public JFrame frame;
    public MyPanel panel1, panel2;

    public PanelRevalidate() {
        frame = new JFrame();
        panel1 = new MyPanel(1);
        panel2 = new MyPanel(2);
        frame.setContentPane(panel1);

        panel1.getSwap().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(panel2);
                frame.revalidate();
                panel2.getTextField().requestFocusInWindow();
            }
        });

        panel2.getSwap().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(panel1);
                frame.revalidate();
                panel1.getTextField().requestFocusInWindow();
            }
        });

        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new PanelRevalidate();
            }
        });
    }

}