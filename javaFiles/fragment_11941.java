btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proc2.setvar(lblfinal.getText());
                parentForm.showPanel(MainPage.PPROCESS);
            }
        });