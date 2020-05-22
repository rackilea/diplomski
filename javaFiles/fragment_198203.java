class FormattedText {
    private String string;
    private int style;

    private static final int PLAIN = 0;
    private static final int BOLD = 1;
    private static final int ITALIC = 2;
    private static final int UNDERLINED = 4;

    FormattedText(String string, boolean bold, boolean italic, boolean underlined)
    {
        this.string = string; 
        if (bold) style |= BOLD;
        if (italic) style |= ITALIC;
        if (underlined) style |= UNDERLINED;
    }


    public String getString() {
        return string;
    }

    public boolean isBold() {
        return (style & BOLD) != 0;
    }

    public boolean isItalic() {
        return (style & ITALIC) != 0;
    }

    public boolean isUnderlined() {
        return (style & UNDERLINED) != 0;
    }   
}