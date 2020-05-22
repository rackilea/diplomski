try
{
   s = new Scanner((Readable) new BufferedReader(new FileReader("file_name")));
   while (s.hasNext())
      System.out.println(s.next());
   } catch (IOException e)
   {
      // Do the error stuff.
      e.printStackTrace();
   } finally
   {
      // Do it anyway. If error happens or not.
      if (s != null)
         s.close();
   }
}