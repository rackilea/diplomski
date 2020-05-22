public Integer Load ( ByteByReference[] pathToFile, LoadResults result ) throws Exception     
{
   // that's the problem!!!! storing the value into another object with another "address"
   // and not the original "results".
   // result = native.getResult (numCore);

   // solved with this:
   native.getResult (numCore, result);
}