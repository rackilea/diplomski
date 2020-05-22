class myApplication extends JFrame implements ActionListener {
    JButton myButton1;
    JButton myButton2;
    JButton myButton3;
    ...

    myApplication() {
        myButton1 = new JButton("<html><center> 2 <br /> ABC </center> </html>");
        ...
        myButton2 = new JButton("<html><center> 3 <br /> DEF </center> </html>");
        ...
    }

    public void actionPerformed(ActionEvent e) { ... }
}