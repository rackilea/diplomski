final JTextField textField = new JTextField();
    final JButton submitBtn = new JButton();
    submitBtn.setEnabled(true);

    textField.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) {
            validate(e);
        }
        public void removeUpdate(DocumentEvent e) {
            validate(e);
        }
        public void insertUpdate(DocumentEvent e) {
            validate(e);
        }

        public void validate(String enteredText) {
            String currText = "";
            try {
                Document doc = (Document)e.getDocument();
                currText = doc.getText(0, doc.getLength());
            } catch (BadLocationException e1) {
                e1.printStackTrace();
            }
            //validation of currText here

            //if validated successfully
            submitBtn.setEnabled(true);
            //else
            submitBtn.setEnabled(false);
        }
    });