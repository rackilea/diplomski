while(objIn.readObject() != null)                         // reads object, tests then *discards* it
{
  ...

  if(objIn.readObject() instanceof PinPW)                 // reads object, tests then *discards* it
  {
    this.PWlist[this.nrOfPW] = (PinPW)objIn.readObject(); // conditionally read an object
    this.nrOfPW++;
  }
  else
  {
    this.PWlist[this.nrOfPW] = (longPW)objIn.readObject(); // conditionally read an object
    this.nrOfPW++;
  }
}