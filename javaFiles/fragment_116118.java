private int tempvalue = 0;

btnEnter.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String getTxt = textField.getText();
        int value = 0;

        try{
            value = Integer.parseInt(getTxt);
        }catch(Exception e1){
            System.out.println("Your input could not be parsed to a number");
        }

        tempvalue += value;

        System.out.println("Result: "+tempvalue);

        }
    });
}