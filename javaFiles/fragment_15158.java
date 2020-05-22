DocumentListener listener = new DocumentListener() {

        private void updatePropertyForEvent(final Properties property, DocumentEvent e) {
            Document document = e.getDocument();
            Object value = document.getProperty("key");
            if (value !=null)
                try {
                    property.setProperty((String) value, document.getText(0, document.getLength()));
                } catch (BadLocationException e1) {
                    // Should not happpen
                    e1.printStackTrace();
                }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updatePropertyForEvent(property, e);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            updatePropertyForEvent(property, e);                
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updatePropertyForEvent(property, e);                
        }
    };