import java.awt.Graphics;
import java.awt.geom.QuadCurve2D;
//...

  g.setClip(new QuadCurve()); // Set the bounding curve for the image.
  g.drawImage(...);