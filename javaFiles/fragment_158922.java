try
{
  if ( myPort.available() > 0) 
  {
    temp = (new String(myPort.readBytesUntil('\n'))).trim();   //Take a string off of the serial     
                                                                 port and remove any spaces
    newval = Integer.parseInt(temp);                            //Convert temp to an integer
  }
}
catch(NullPointerException e)
{
 e.printStackTrace();
}