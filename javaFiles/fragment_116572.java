private void btnDrawShapeActionPerformed(java.awt.event.ActionEvent evt) {     

int centerX;    
int centerY; 

Graphics2D drawFx = (Graphics2D)pnlDrawPad.getGraphics();

drawFx.setColor(Color.ORANGE);

centerX = (int)(458*Math.random());
centerY = (int)(440*Math.random());

drawFx.fillOval(centerX-50, centerY-50, 100, 100);

drawFx.dispose();

}