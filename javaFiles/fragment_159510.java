import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;

public class FontIconGlyphButton extends JComponent
{
    // to avoid wrong glyph codes
    public interface FontIconGlyphCode
    {
        char toCharCode();
    }

    private final Color color;
    private final Color hoverColor;
    private final Color disabledColor;
    private final Font font;

    private GlyphVector vector;
    private Rectangle2D size;
    private FontIconGlyphCode iconCode;
    private boolean hover = false;

    public FontIconGlyphButton(Font font, FontIconGlyphCode iconCode, Color color, Color hoverColor, Color disabledColor)
    {
        this(font, iconCode, color, hoverColor, disabledColor, null);
    }

    public FontIconGlyphButton(Font font, FontIconGlyphCode iconCode, Color color, Color hoverColor, Color disabledColor, ActionListener listener)
    {
        this.font = font;
        this.color = color;
        this.hoverColor = hoverColor;
        this.disabledColor = disabledColor;
        setIconCode(iconCode);
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(listener != null)
                    listener.actionPerformed(new ActionEvent(e.getSource(), e.getID(), Action.DEFAULT));
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                hover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                hover = false;
                repaint();
            }
        });
    }

    public void setIconCode(FontIconGlyphCode iconCode)
    {
        this.iconCode = iconCode;
        FontRenderContext context = new FontRenderContext(null, true, true);
        vector = font.createGlyphVector(context, String.valueOf(iconCode.toCharCode()));
        size = vector.getGlyphMetrics(0).getBounds2D();
        repaint();
    }

    public FontIconGlyphCode getIconCode()
    {
        return iconCode;
    }

    @Override
    protected void paintComponent(Graphics g1)
    {
        Graphics2D g = (Graphics2D) g1;
        g.setColor(isEnabled() ? (hover ? hoverColor : color) : disabledColor);
        g.drawGlyphVector(vector, (float) -size.getX(), (float) -size.getY());
    }

    @Override
    public Dimension getMinimumSize()
    {
        return size.getBounds().getSize();
    }

    @Override
    public Dimension getPreferredSize()
    {
        return size.getBounds().getSize();
    }
}