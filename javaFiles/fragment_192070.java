textfield.getDocument().addDocumentListener(this);

@Override
    public void insertUpdate(DocumentEvent e) 
    {
        textField1.setBackground(textField1.getText().equalsIgnoreCase("") ? Color.RED : Color.GREEN);
    }

    @Override
    public void removeUpdate(DocumentEvent e) 
    {
        textField1.setBackground(textField1.getText().equalsIgnoreCase("") ? Color.RED : Color.GREEN);
    }

    @Override
    public void changedUpdate(DocumentEvent e) 
    {
        textField1.setBackground(textField1.getText().equalsIgnoreCase("") ? Color.RED : Color.GREEN);    
    }