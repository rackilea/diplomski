public static void main(String args[]){
    JButton btn1 = new JButton("btn1");
    btn1.setActionCommand("btn1");

    JButton btn2 = new JButton("btn2");
    btn2.setActionCommand("btn2");

    btn1.addActionListener(this);
    btn2.addActionListener(this);
}

@Override
public void actionPerformed(ActionEvent ae) {
    String sourceBtn = ae.getActionCommand();
    System.out.println(sourceBtn + "Button pressed!");
}