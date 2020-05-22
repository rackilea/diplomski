public class MyStyleContext extends javax.swing.text.StyleContext
{
    @Override public Font getFont(AttributeSet attr)
    {
        Font font = attr.getAttribute("MyFont");
        if (font != null)
            return font;
        else
            return super.getFont(attr);
    }
}