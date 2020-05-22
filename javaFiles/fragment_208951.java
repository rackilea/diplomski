try
{
  ch = System.in.read();  //reads from keyboard.

  if ( ch == EOF ) 
  {
    System.out.println("**** END OF FILE " + 
                       "detected on input -- EXIT ****" );
    System.exit(-1);
  }
}