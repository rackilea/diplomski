else
{
  drawingArea.drawLine( midX, bottomY, midX, topY );

  drawRuler( leftX, midX, topY/2, bottomY, drawingArea );
  drawRuler( midX, rightX, topY/2, bottomY, drawingArea );
}