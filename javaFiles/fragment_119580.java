public class Testing {

        public static void main(String[] args) {
                JFrame frame = new JFrame("hi");

                for (int i = 0; i < 10; i++) {
                        JButton a = new JButton();
                        a.setSize(20,20);
                        a.setLocation(20*i, 0);
                        frame.getContentPane().add(a);

                }
                frame.setLayout(null);
                frame.pack();
                frame.setVisible(true);
        }

}