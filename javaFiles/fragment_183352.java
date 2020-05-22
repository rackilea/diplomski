Document document = jTextFiled.getDocument();
    document.addDocumentListener(new DocumentListener() {

        @Override
        public void insertUpdate(DocumentEvent e) {
            check();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            check();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            check();
        }

        private void check() {
            if (!isInteger(jTextFiled.getText())) {
                jButton.setEnabled(false);
            } else {
                jButton.setEnabled(true);
            }
        }

    });