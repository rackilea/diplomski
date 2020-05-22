int a=0;

switch (something)
{
    case 1:{
        a = 3;
        ...
        break;
     }
     case 2:{
        a = 4;
        ....
       break;
    }
    default:
    {
       try{
           throw new IllegalStateException();
       }catch(IllegalStateException e)
       {
           e.printStackTrace();
       } 
   } 
 }