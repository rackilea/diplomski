try {
 MifareClassic mfc = MifareClassic.get(tag);
 String key = getKeya();

 key = toHex(key).toUpperCase();
  int len = key.length();
   key = key.substring(28,40);
   keya = new BigInteger(key, 16).toByteArray();

  //for key A or for Keb b


            mfc.connect();
            auth = mfc.authenticateSectorWithKeyA(5, keya);
        if(auth)
        {


  byte[] readblock4=    mfc.readBlock(20);

  }
  }
 catch(Exeption e)
 {

 }