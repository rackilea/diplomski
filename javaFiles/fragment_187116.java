//  Create shared DocumentListener

DocumentListener dl = new DocumentListener()
{
    @Override
    public void removeUpdate(DocumentEvent de)
    {
        resizeTextField(de);
    }

    @Override
    public void insertUpdate(DocumentEvent de)
    {
        resizeTextField(de);
    }

    @Override
    public void changedUpdate(DocumentEvent de) {}

    private void resizeTextField(DocumentEvent de)
    {
        innerContentPane.revalidate();
    }
};

GridBagConstraints c = new GridBagConstraints();
c.gridx = 0;
c.gridy = 0;
//c.weighty = 0.1;
//c.weightx = 0.1;
//c.fill = GridBagConstraints.BOTH;

//  Create text fields and add listener to the Document

for(int row = 0; row < 3; row++)
{
    for(int col = 0; col <3; col++)
    {
            JTextField textField = new JTextField("0");
            textFields[row][col] = textField;
            textField.getDocument().addDocumentListener(dl);
            c.gridx = col;
            c.gridy = row;
            innerContentPane.add(textField, c);
    }
}