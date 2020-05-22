public static void main(String[] a)
{
  Picture p; // constructor is a method - but seems you instantiate it in next line
  p =new Picture(FileChooser.pickAFile( )); // assign it to p
  Pixel pixRef = new Pixel(); //avoid nullpointerexception! but logically you should get the pixel from the picture, which displayed in next line, can remove the "new Pixel()";
  pixRef = p.getPixel(2,3); // Shouldn't you get pixelref from picture?
  pixRef.setColor(java.awt.Color.Black);
  p.show(); // I don't understand this. Where do you show this? shouldn't you put it inside a Frame or something?
}