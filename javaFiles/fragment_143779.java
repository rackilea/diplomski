comboBox.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e){
            {
                serverText.setText( (String) item.getServerName());
                portText.setText( (String) item.getPortNumber());
                usernameText.setText( (String) item.getUserName());
                passwordText.setText( (String) item.getPassword());
      }
    }
});