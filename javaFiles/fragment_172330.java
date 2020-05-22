public class BackgroundColorAction extends StyledEditorKit.StyledTextAction {

    private Color color;

    public BackgroundColorAction(Color color) {
        super(StyleConstants.Background.toString());
        this.color = color;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JEditorPane editor = getEditor(ae);
        if (editor == null) {
            return;
        }
        //Add span Tag
        String htmlStyle = "background-color:" + Util.getHTMLColor(color);
        SimpleAttributeSet attr = new SimpleAttributeSet();
        attr.addAttribute(HTML.Attribute.STYLE, htmlStyle);
        MutableAttributeSet outerAttr = new SimpleAttributeSet();
        outerAttr.addAttribute(HTML.Tag.SPAN, attr);
        //Next line is just an instruction to editor to change color
        StyleConstants.setBackground(outerAttr, this.color);
        setCharacterAttributes(editor, outerAttr, false);
    }
}