JComboBox<String> cbchoiceShowHide;
JTextField field;
public void init(){

        //set flow layout for the applet
        this.getContentPane().setLayout(new FlowLayout());

        //create new JTextField
        field = new JTextField("JTextField Show Hide Example", 20);
        field.setVisible(true);
        add(field);

        String[] choiceShowHide =  
            { "" + "Show","Hide"
            };
        cbchoiceShowHide = new JComboBox<String>(choiceShowHide);
        cbchoiceShowHide.setVisible(true);
        add(cbchoiceShowHide);
        cbchoiceShowHide.addActionListener(this);
}

@Override
public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if(cbchoiceShowHide.getSelectedItem().toString().equalsIgnoreCase("show"))
        field.setVisible(true);
    else
        field.setVisible(false);
    }
}