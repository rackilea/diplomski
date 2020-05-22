pass.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent arg0) {
            if(elbtUser.getText().equals("")) {

              //do this *BEFORE* displaying the dialog!!!
                elbtUser.requestFocus(false);

                JOptionPane.showMessageDialog(null, "username cannot be empty");

            }
            else {

            }
        }
    });