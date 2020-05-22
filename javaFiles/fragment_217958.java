public class MyShape extends Shape {
   private String name;
   private static int shapeCount = 1;

   public MyShape() {
      name = "Shape " + shapeCount;
      shapeCount++;
   }

   @Override
   public void display(Graphics page) {
      page.setColor(color);
      page.fillOval(x, y, width, height);
   }

   @Override
   public void move() {
      System.out.printf("%s: [x: %d, y: %d, w: %d, h: %d, mX: %d, my: %d]%n", 
            name, x, y, width, height, moveX, moveY);
      // Rebound X
      if (x <= 0 || x >= 400 - width) {
         moveX = moveX * -1;
      }

      // ... etc...