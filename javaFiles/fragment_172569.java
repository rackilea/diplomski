txtUser.getDocument().addDocumentListener(new DocumentListener() {

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                getBtnSave().setEnabled(
                    !getTxtUser().getText().isEmpty() &&
                    !getTxtPass().getText().isEmpty());
                    }

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                getBtnSave().setEnabled(
                    !getTxtUser().getText().isEmpty() &&
                    !getTxtPass().getText().isEmpty());
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                getBtnSave().setEnabled(
                    !getTxtUser().getText().isEmpty() &&
                    !getTxtPass().getText().isEmpty());
                    }
                });