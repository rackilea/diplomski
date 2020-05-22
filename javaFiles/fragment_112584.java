JTextField[] jtextf;// global variable

 String[] textFieldList = {"Name", "Age", "Height", "weight"};
 jtextf=new JTextField[textFieldList.length];

 formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

    for (int i=0;i<textFieldList.length;i++) {

        JLabel jl = new JLabel(tfL);
        jtextf[i] = new JTextField("");
        jtextf[i].setName(textFieldList[i]);
        formPanel.add(jl);
        formPanel.add(jtextf[i]);
    }
}