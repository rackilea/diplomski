while (!msgCompleted && !overallTimeout)
{
   bytesRead = netstream.Read(readBuffer);

   if (bytesRead > 0)
   {
      // here append readBuffer to msgBuffer from offset to offset+bytesRead 

      offset += bytesRead // update offset so you can keep appending

     // inspect the msgBuffer to see if the message is completed
   }

}