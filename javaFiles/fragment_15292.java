long fileSizeByteLimit = 5000000;
long bytesOutput = 0;

while(THEREAREMORELINESTOOUTPUT)  {

   //Open a new file
   while(bytesOutput <= fileSizeByteLimit)  {
      writer.append(lineOfOutput);
      bytesOutput += lineOfOutput.length();
   }
   //Close file

}