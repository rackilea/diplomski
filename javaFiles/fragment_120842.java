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