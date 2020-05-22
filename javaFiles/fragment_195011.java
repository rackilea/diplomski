class FontSetter {

private final JTextField text;
private String fontName = "Times";
private boolean isBold = false;
private boolean isItalic = false;

FontSetter(JTextField text) {
    this.text = text;
}

void setBold(boolean flag) {
    isBold = flag;
    applyFontChanges();
}

void setItalic(boolean flag) {
    isItalic = flag;
    applyFontChanges();
}

void setFontName(String fontName) {
    this.fontName = fontName;
    applyFontChanges();
}

private void applyFontChanges(){
    Font font;
    int style;

    if(isBold && isItalic){
        style = Font.BOLD + Font.ITALIC;
    } else if(isBold){
        style = Font.BOLD;
    } else if(isItalic){
        style = Font.ITALIC;
    } else {
        style = Font.PLAIN;
    }

    font = new Font(fontName, style, 12);
    text.setFont(font );
}   
}