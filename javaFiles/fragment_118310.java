for(int x = 0; x < 10; x++)
{
   if(array[x].equals("Something that will make me want to cancel"))
   {
       break;
   }
   else if(array[x].equals("Something else that will make me want to cancel"))
   {
       break;
   }
   else if(array[x].equals("This is what I want"))
   {
       item = array[x];
   }
}