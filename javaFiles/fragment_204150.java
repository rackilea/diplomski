public class Test {

        static double d = 0;

        public static void main(String[] args) {
            JButton b = new JButton("ASDF");
            b.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    d = 5;
                }

            });
        }
    }