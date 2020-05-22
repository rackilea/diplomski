Runnable function()
{
   final int i = 4;
   return new Runnable()
   {
       public void run()
       {
            System.out.println("i="+i);
            // can't modify i here
       }
   }
}