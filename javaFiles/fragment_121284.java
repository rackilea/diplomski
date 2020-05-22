//Example
class MyPanel extends JPanel{
    private JButton btn1, btn2;

    public MyPanel(){
        btn1 = new JButton("Button 1");
        btn2 = new JButton("Button 2");
        ButtonHandler bn = new ButtonHandler();
        btn1.addActionListener(bh);
        btn2.addActionListener(bh);
    }
}