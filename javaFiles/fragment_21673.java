.
if (fw != null) 
{
   try 
   {
       fw.flush();
       fw.close();
   } catch (IOException exception) 
   {
       System.err.println("Error closing writer");
       exception.printStackTrace();
   }
}
.
.