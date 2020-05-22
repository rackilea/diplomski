JPanel p = new JPanel(new GridLayout(2,2));
    JTextField nameField = new JTextField(5);
    JTextField numberField = new JTextField(5);
    JLabel nameLabel = new JLabel("Name");
    JLabel numberLabel = new JLabel("Number");

    p.add(nameLabel);
    p.add(nameField);
    p.add(numberLabel);
    p.add(numberField);

    while(true){
        int result = JOptionPane.showConfirmDialog(null, p, "Please enter Name and Number.", JOptionPane.OK_CANCEL_OPTION);

        if(result == JOptionPane.OK_OPTION){
            if(nameField.getText().equals("")){
                JOptionPane.showConfirmDialog(null, "Invalid input!");
            }
            else break;
        }
    }