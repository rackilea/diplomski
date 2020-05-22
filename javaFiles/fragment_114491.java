for( int i=127;i < 256;i++)
        {
            byte[] char= new byte[1];
            char[0]= (byte)i;
            System.out.println("Data : "+char+","+
new String(char, "ISO-8859-1")+","+i); //'i' will give u code. 197 is for Å so on.
        }