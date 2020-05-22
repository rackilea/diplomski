MifareClassic mfc = MifareClassic.get(tag);

        try {
            mfc.connect();
            auth = mfc.authenticateSectorWithKeyA(5, 
 MifareClassic.KEY_DEFAULT);
        if(auth)
        {
         String nkeya = "key123";// 6 length only
                nkeya = toHex(nkeya).toUpperCase();
                nkeya = nkeya.substring(28,40);

                String nkeyb = "key123"; // 6 length only
                nkeyb = toHex(nkeyb).toUpperCase();
                nkeyb = nkeyb.substring(28,40);

                String nkey = nkeya+"FF078069"+nkeyb;
                int len = nkey.length();

                byte[] nkeyab = new BigInteger(nkey, 16).toByteArray();
                // 5 is sector and 5*4+3 is fourth block of sector 5
                mfc.writeBlock((5*4)+3,nkeyab);

}
catch(Execption e)
 {
 }