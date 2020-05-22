...
try
{
    imagePath = DialogIO.displayOpenDialog();
    effects = ImageInOut.loadImage(imagePath);                
    imageHolder.setIcon(new ImageIcon(effects));
    bmpFound = true;
    bmpChecker();
}
...