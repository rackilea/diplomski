class A extends JFrame {

    private JButton button = new JButton ();
    private int a;

    {
        button.addActionListener (new B ());
    }

    class B implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            if (e.getSource () == button) {
                System.out.println (a);
            }
        }

    }

}