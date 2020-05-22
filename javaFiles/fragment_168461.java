class AddDigit extends TextAction
{
    private String digit;

    public AddDigit(String digit)
    {
        super( digit );
        this.digit = digit;
    }

    public void actionPerformed(ActionEvent e)
    {
        JTextComponent component = getFocusedComponent();
        component.replaceSelection( digit );
    }
}