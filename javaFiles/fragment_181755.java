public static void main( String[] args ) throws IOException
{
  BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
  boolean awaitInput = true;
  long timeout = System.currentTimeMillis() + 5_000;
  //                                          ^^^^^ 5_000ms = 5 sec 

  while(awaitInput && System.currentTimeMillis() < timeout)
  {
    if(br.ready())
    {
      awaitInput = false;
      String line = br.readLine();
      // read logic
    }
  }
}