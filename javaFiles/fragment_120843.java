public class Direction
{
    // You are pretty new so I wouldn't confuse you with public,protected and private here
    public int x;
    public int y;

    public Direction( int xArg , int yArg )
    {
        this.x = xArg;
        this.y = yArg; 
    }

    public Direction() // No-Arg Constructor, give default values here
    {
        // this could really be initialized to fit your taste 
        this.x = -1; 
        this.y = 1;
    } 

    @Override
    public String toString()
    {
       // Testing for (-1 , 1) 
       if( this.x < 0 && this.y > 0 )
       {
           return "<up right>";
       }
       // Testing for (1 , -1)
       else if( this.x > 0 && this.y < 0 )
       { 
          return "<down left>"; 
       }
       // Testing for (1 , 0)
       else if( this.x > 0 && this.y == 0 )
       {
          return "<down>"; 
       }  
       // Since none of the above executed, we assume that it's (0 , -1) case
       else
       {
           return "<up>"; 
       }

    }
}