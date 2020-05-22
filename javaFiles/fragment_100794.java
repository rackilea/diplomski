final JComboBox date1 = new JComboBox(date);
date1.addActionListener(new ActionListener() {//add actionlistner to listen for change
    @Override
    public void actionPerformed(ActionEvent e) {

        String s = (String) date1.getSelectedItem();//get the selected item

        switch (s) {//check for a match
            case "Day":
                emailvalue = 30;
                break;
            case "Week":
                emailvalue = 4;
                break;
            case "Month":
                emailvalue = 1;
                System.out.println("Month selected, emailvalue:" + emailvalue);
                break;
        }
    }
});
date1.setSelectedItem(date[0]);//set Day as default selected item/emailvalue