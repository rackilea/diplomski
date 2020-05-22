while (true) 
{
  int b = requestedfile.read();
  if (b == -1) {
    break; //end of file
  }
  output.write(b);
}