fNameTF.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
              doOnDataValidity(verifier.verify(fNameTF));
           }

            @Override
            public void removeUpdate(DocumentEvent e) {
               doOnDataValidity(verifier.verify(fNameTF));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });