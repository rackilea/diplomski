public class Test {

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton button = new JButton("Test");                       
        button.setBounds(20, 30, 100, 40);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                panel.setBackground(Color.red);
                panel.setBounds(215, 2, 480, 480);
                frame.add(panel);
                frame.revalidate(); // Repaint here!! Removing these calls
                frame.repaint(); // demonstrates the problem you are having.

            }
        }); 

        frame.add(button);
        frame.setSize(695, 482);
        frame.setVisible(true);              

    }
}