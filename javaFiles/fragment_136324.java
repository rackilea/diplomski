StringBuffer buffer = new StringBuffer();
File file = new File(arg);
FileInputStream in = new FileInputStream(file);
DataInputStream dis = new DataInputStream(new BufferedInputStream(in));
int ch;

while ((ch = din.read()) > -1){
    buffer.append((char)ch);
    if (ch == ' ')
    {
        // next byte is a binary value
        byte b = din.readByte();
        String x = Integer.toString(b & 0xFF, 2);
        System.out.println(x);
    }
}