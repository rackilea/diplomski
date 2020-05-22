int j=0;
  byte[] byteArray=new byte[4];
  int data=Float.floatToIntBits(asFloat);
  byteArray[j++]=(byte)(data>>>24);
  byteArray[j++]=(byte)(data>>>16);
  byteArray[j++]=(byte)(data>>>8);
  byteArray[j++]=(byte)(data>>>0);