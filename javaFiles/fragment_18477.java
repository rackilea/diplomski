Runnable function()
{
   final int[] i = new int[1];
   i[0] = 4;
   return new Runnable()
   {
       public void run()
       {
            System.out.println("i="+i[0]);
            i[0] = i[0] + 1;
       }
   }
}