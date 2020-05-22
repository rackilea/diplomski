exitBtn.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            int selectedOption = JOptionPane.showConfirmDialog(null, 
                              "Do you want to close the window?", 
                              "Choose", 
                              JOptionPane.YES_NO_OPTION); 
            if (selectedOption == JOptionPane.YES_OPTION) {
                    System.exit(1);

            }
        }
    });