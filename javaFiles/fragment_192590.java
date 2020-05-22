import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;

public class CustomField extends Field
{

private int backgroundColour; 
private int fieldWidth;
private int fieldHeight; 
private int padding = 8;

public CustomField(int color)
{
    super(Field.FOCUSABLE); 
    fieldHeight = 100;
    fieldWidth = 100;
    this.setPadding(2, 2, 2, 2);
    this.backgroundColour=color;
} 

public int getPreferredWidth()
{
    return fieldWidth;
}

public int getPreferredHeight()
{
    return fieldHeight;
}

protected void layout(int arg0, int arg1)
{
    setExtent(getPreferredWidth(), getPreferredHeight());
}

protected void drawFocus(Graphics graphics, boolean on)
{

} 

protected void paint(Graphics graphics)
{
    graphics.setColor(backgroundColour);
    graphics.fillRect(0, 0, fieldWidth, fieldHeight); 
}
}