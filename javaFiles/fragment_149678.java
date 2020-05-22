public class Player 
 {
    private int x, y, dx, dy;

    public void checkCollision(Block block)
    {
       if (isTopCollision(block))
         fall(block.getY() + block.getHeight());
    }

    private boolean isTopCollision(Block block)
    {
       return y > block.getY() + block.getSize() && y < block.getY();
    }

    private void fall(int adjustedY)
    {
       y = adjustedY;
       top = true;
       dy = 0;
       // etc
    }
 }

 public class MyGame 
 {
     public void gameloop()
     {
       for (Block b : blocks)
         player.checkCollision(b);
     }
 }