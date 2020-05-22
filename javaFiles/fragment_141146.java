public class JavaApplication1 extends JFrame implements ActionListener
    {
        private JTextField aw1;
        private JLabel aww;
        private JButton aw2;

        public JavaApplication1()
        {
            setLayout(new FlowLayout());

            aww = new JLabel("Enter Your Password");
            add(aww);

            aw1 = new JTextField(15);
            add(aw1);

            aw2 = new JButton("Enter");
            add(aw2);
            setVisible(true);

        }
        public static void main(String args [])
        {
        JavaApplication1 v = new JavaApplication1();

                v.setSize(200,200);
                v.setResizable(false);
                v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Add your functionality here
        }
    }