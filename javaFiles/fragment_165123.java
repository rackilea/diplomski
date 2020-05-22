Pixmap.setBlending(Pixmap.Blending.None); // before you start drawing pixels.

pixmap.drawPixel(x, y, 0x00000000);
// And all pixels you want to draw

Pixmap.setBlending(Pixmap.Blending.SourceOver); // if you want to go back to blending