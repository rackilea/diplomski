int bytesRead; // Easier to understand than "ss"
byte[] buffer = new byte[500];

while((bytesRead = di.read(buffer, 0, buffer.length)) != -1)
{
    System.out.println(bytesRead);
    fout.write(buffer, 0, bytesRead);
}