public void paintComponent(Graphic g) {

     Graphics2D g2d = (Graphics2D) g;
     AffineTransform saveTransform = g2d.getTransform();

     try {
         AffineTransform scaleMatrix = new AffineTransform();
         scaleMatrix.scale(1.5, 1.5);
         //or whatever you want

         g2d.setTransform(scaleMatrix);
         g2d.drawPolygon(myPolygon);
     } finally {
         g2d.setTransform(saveTransform);
     }
}