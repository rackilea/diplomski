public class AddContent {
    private User darryl = new User();

    public void addStuff(){

        //Panel and Frame
        JPanel panel = new JPanel(new BorderLayout());
        JFrame frame = new JFrame("PandaHunterV3");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Setup labels
        JLabel label = new JLabel("Label");
        frame.getContentPane().add(label);
        //Setup buttons
        JButton button = new JButton("Button");
        frame.getContentPane().add(button);
        //Action listener
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                AddContent.this.darryl.showHealth();    // SHOULD BE FINE
            }
        });
        //Crap
        frame.pack();
        frame.setVisible(true);


}

}