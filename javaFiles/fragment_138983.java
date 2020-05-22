//based on your description.
int imageWidth = 800;
int imageHeight = 100;
int x = (getWidth() - imageWidth)/2;
int y = (getHeight() - imageHeight)/2;
g.drawImage(bg, x, y, imageWidth, imageHeight, this);