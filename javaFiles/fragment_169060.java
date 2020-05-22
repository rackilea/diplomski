JFrame frame = new JFrame();
    frame.setSize(400, 500);
    frame.setVisible(true);
    frame.setLayout(null);

    ArrayList<JButton> buttons = new ArrayList<JButton>();
    JButton b1= new JButton();
    JButton b2= new JButton();
    JButton b3= new JButton();
    JButton b4= new JButton();
    JButton b5= new JButton();

    buttons.add(b1);
    buttons.add(b2);
    buttons.add(b3);
    buttons.add(b4);
    buttons.add(b5);
    int count = 1;
    for(JButton b: buttons)
    {
        b.setText(String.valueOf(count));
        b.setBounds(0,count*50,50,30);
        frame.add(b);
        count++;
    }