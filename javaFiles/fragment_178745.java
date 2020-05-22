JTextField field = new JTextField(20);
    field.getDocument().addDocumentListener(new DocumentListener() {

        public void verify() {
            int length = field.getText().trim().length();
            if (length >= 16 && length <= 17) {
                field.setBackground(null);
            } else {
                field.setBackground(Color.RED);
            }
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            verify();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            verify();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            verify();
        }
    });
    field.setText(" ");
    field.setText(null);