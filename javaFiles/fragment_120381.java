btnSubmit.setFont(new Font("Verdana", Font.PLAIN, 12));
    btnSubmit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            if(!textField.getText().equals(""))
            {
             btnSubmit.setText("Working...");
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        ft.FindSpot(textField.getText(), comboBox.getSelectedItem().toString(), progressBar);
                    }
                });

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        btnSubmit.setText("Submit");
                    }
                });
            }
            else
            {
                ft.warningMessage("The ISCII textbox cannot be blank.");
            }
        }
    });