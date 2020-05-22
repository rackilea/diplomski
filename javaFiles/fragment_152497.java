while (true)
{
   fileLengthClosed = file.length();

   if (fileLengthClosed == size)
      break;

   Thread.sleep(1);
}