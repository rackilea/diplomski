public static void main( String[] args ) throws IOException
{

  boolean awaitInput = true;

  while(awaitInput)
  {
    if(System.in.available() != 0)
    {
      awaitInput = false;
      // read logic
    }
  }
}