public Direction getMove()
{
   Object dir = Direction.WEST;    
   switch(count%4)
   {
      case 0: Direction.NORTH;
      case 1: Direction.NORTH;
      case 2: Direction.NORTH;    
   }
   count++;
   return dir;

 }