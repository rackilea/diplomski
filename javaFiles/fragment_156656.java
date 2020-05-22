btnFind.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String strTextField_6 = textField_6.getText();

            if ("".equals(strTextField_6)) {
                FindStudent fs = new FindStudent();
                fs.setModal(true);
                fs.setVisible(true);
            }

            SchoolInterfaceImpl sii = new SchoolInterfaceImpl();
            sii.find(strTextField_6);

        }
    });