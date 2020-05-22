...
if(isGraphicsVisibile())
{
    composer.beginLocalState();
    composer.setLineWidth(lineWidth);
    composer.setFillColor(getBackColor());
    composer.setStrokeColor(getForeColor());
    composer.drawRectangle(frame, 5);
    composer.fillStroke();
    composer.end();
}
...