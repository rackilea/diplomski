public static void main(String[] args) throws Exception{

    Music m = new Music(); // ****** Music plays here
    m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    m.setSize(300,300);
    JButton button = new JButton("Click here for 4 second part of the music");
    m.add(button);
    button.addActionListener(new AL());
    m.setVisible(true);


}