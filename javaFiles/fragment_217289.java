ActionListener al = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // You can check which button was pressed and act accordingly
        // simply by checking the event source:
        if (e.getSource() == button1)
            System.out.println("Button1 was pressed.");
        else if (e.getSource() == button2)
            System.out.println("Button2 was pressed.");
    }
};

button1.addActionListener(al);
button2.addActionListener(al);