Rectangle2D bounds = font.getStringBounds(sampleText, frc);
int w = (int) bounds.getWidth();
int h = (int) bounds.getHeight();

String[] parts = sampleText.split("\n");
//create a BufferedImage object
BufferedImage image = new BufferedImage(w, h * parts.length,   BufferedImage.TYPE_INT_RGB);

int index = 0;  
for(String part : parts){
    g.drawString(part, 0,  h * index++);
}