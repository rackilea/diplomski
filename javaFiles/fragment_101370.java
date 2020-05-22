try
 {
   while (true)
   {
     final Object o = objIn.readObject();            // read the object from the stream

     ...

     if (o instanceof PinPW)
     {
       this.PWlist[this.nrOfPW] = (PinPW) o;         // cast to correct type
       this.nrOfPW++;
     }
     else
     {
       this.PWlist[this.nrOfPW] = (longPW) o;        // cast to correct type
       this.nrOfPW++;
     }
   }
 }
 catch (EOFException e)
 {
   // end of stream reached ...
   // ... close the file descriptor etc ...
 }