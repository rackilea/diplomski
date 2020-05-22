class MyFrame extends JFrame {

    public MyFrame() {

        JComponent allMyStuff = new JComponent();
        JComponent allMyOtherStuff = new JComponent();

        this.getContentPane().setLayout(new CardLayout());

        this.getContentPane().add(allMyStuff, "1");
        this.getContentPane().add(allMyOtherStuff, "2");

        CardLayout cl = (CardLayout) (this.getContentPane().getLayout());
        cl.show(this.getContentPane(), "1");

        JButton b = new JButton("Open New Window"); //add somewhere to first compoonent
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                CardLayout cl = (CardLayout) (this.getContentPane().getLayout());
                cl.show(this.getContentPane(), "2");
            }
        });
    }
}