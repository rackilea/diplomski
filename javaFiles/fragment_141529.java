JButton button = new JButton("Button");
        JTextField field = new JTextField();
        field.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                if(field.getText().isEmpty()){
                    button.setEnabled(true);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                if(field.getText().isEmpty()){
                    button.setEnabled(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                if(field.getText().isEmpty()){
                    button.setEnabled(true);
                }
            }

        });