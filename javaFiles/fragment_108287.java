public void actionPerformed(ActionEvent e) {
    if (e.getSource() == buttonA)
    {
        ButtonAImpl x = new ButtonAImpl();
        x.myMethod();
    }
    if (e.getSource() == buttonB)
    {
        ButtonBImpl y = new ButtonBImpl();
        y.myMethod();
    }
 }