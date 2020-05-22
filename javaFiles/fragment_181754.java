public static void main( String[] args ) throws IOException
{

  BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );

  boolean awaitInput = true;

  while(awaitInput)
  {
    if(br.ready())
    {
      awaitInput = false;
      String line = br.readLine();
      // read logic
    }
  }
}