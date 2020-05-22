JTextField textField = new JTextField(20);

            DocumentListener documentListener = new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    onTextChange();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    onTextChange();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    onTextChange();
                }

                public void onTextChange() {
                    String text = textField.getText();
                    if(text.length() > 0){
                         // display the data
                    }
                }
            };

            textField .getDocument().addDocumentListener(documentListener);