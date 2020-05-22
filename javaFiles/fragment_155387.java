// Pseudo code
while (capturing)
{
    grab bufferedImage (screenCapture) from screen
    convert bufferImage to byte array
    start asynchronous file channel to write to the output file
      and add the future reference (return value) to the ArrayList
}