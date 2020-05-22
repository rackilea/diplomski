RandomAccessFile rand = ... // Your RandomAccessFile instance.

rand.seek(0);

for (long i = 0; i < rand.length(); i++) 
{
    byte b = rand.readByte();
    System.out.print((char)b);
}