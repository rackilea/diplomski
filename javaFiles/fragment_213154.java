public static short createManuID(String id)
  {
      int bitMashedManuID = 0;
      id = id.toUpperCase(); //force the chars to be within 65-90
      if(id.length() == 3)
      {
          short offset = 65; //A = 0, B = 1 ... Z = 25
          //number bits needed to fit 0-25 and so values won't overlap during the bit mashing
          short bitShift = 5; 
          for(int i = 0; i < id.length(); i++)
          {
              short valueOfChar = (short)id.charAt(i);
              valueOfChar -= offset; //apply the offset
              bitMashedManuID += valueOfChar << bitShift * i; //pack the bits
          }
      }
      return (short)bitMashedManuID;
  }