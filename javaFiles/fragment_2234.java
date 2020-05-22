for (int i =0; i<xByteArray.length;i++)
           for (int j=0; j<yByteArray.length;j++){
               // convert bytes to ints
               int xDigit = xByteArray[i], yDigit = yByteArray[j];
               // convert signed to unsigned
               if (xDigit < 0)
                   xDigit += 256;
               if (yDigit < 0)
                   yDigit += 256;
               // compute result of multiplication
               int result = xDigit * yDigit;
               // capture low order byte
               rowsAndColumns[i][j] = (byte)(result & 0xFF);
               // get overflow (high order byte)
               int overflow = result >> 8;
               // handle overflow here
               // ...
           }