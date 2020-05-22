class DefaultDocFilter extends DocumentFilter
{   
    private int charLimit = 40;

    public void insertString(FilterBypass fb, int offs,
         String str, AttributeSet a) 
    {
        //do something with charLimit 
    }

    public void replace(FilterBypass fb, int offs, int length,
         String str, AttributeSet a)
    {
        //do something else with charLimit
    }

    public int getCharLimit() {
        return charLimit;
    }

    public void setCharLimit(int charLimit) {
        this.charLimit = charLimit;
    }
}