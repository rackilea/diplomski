public static void main(String[] args)
{
  System.out.println("Starting perfo test");

  final long NUM_TESTS = 100000000L;

  String wibble = "<blah> blah blah </blah>.... <wibble>"
                + " blah wibble blah </wibble> some more test here";
  int x = -1;
  Stopwatch sw = new Stopwatch();

  System.out.println("--perfo test with " + NUM_TESTS + " iterations--");

  sw.start();
  for(long i = 0; i < NUM_TESTS; i++)
    x = wibble.lastIndexOf(">");
  sw.stop();
  System.out.println("String first pass: " + sw + " seconds");

  sw.start();
  for(long i = 0; i < NUM_TESTS; i++)
    x = wibble.lastIndexOf('>');
  sw.stop();
  System.out.println("Char first pass: " + sw + " seconds");

  sw.start();
  for(long i = 0; i < NUM_TESTS; i++)
    x = wibble.lastIndexOf('>');
  sw.stop();
  System.out.println("Char second pass: " + sw + " seconds");

  sw.start();
  for(long i = 0; i < NUM_TESTS; i++)
    x = wibble.lastIndexOf(">");
  sw.stop();
  System.out.println("String second pass: " + sw + " seconds");

  //Compiler warning said x was never read locally.. this is to
  //ensure the compiler doesn't optimize "x" away..
  System.out.println(x); 
}