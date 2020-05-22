public class Form extends JFrame {

    public Form(){
        JButton show = new JButton("show Form2");
        show.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                new Form2();
                Form.this.setVisible(false);
            }

        });
        setTitle("Form 1");
        getContentPane().add(show,BorderLayout.CENTER);
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    class Form2 extends JFrame {

        public Form2(){
            JButton show = new JButton("show Form");
            show.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    new Form();
                    Form2.this.setVisible(false);
                }

            });
            setTitle("Form 2");
            getContentPane().add(show,BorderLayout.CENTER);
            setLocationRelativeTo(null);
            pack();
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Form();
    }
}