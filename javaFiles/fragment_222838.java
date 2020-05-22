BufferedInputStream stream=new BufferedInputStream(new FileInputStream("file.bin"));
byte[] buff=new byte[256];
String[] result=new String[10];
for(int i=0;i<10;i++){
    int n=(reader.read()<<8)|reader.read();    // string length (assuming all strings are less than 64K)
    if(buff.length<n) buff=new byte[n];
    reader.read(buff,0,n);
    result[i]=new String(buff,0,n);
}
stream.close();