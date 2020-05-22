byte[] buffer = new byte[4096];
int current;
int fileLength = fromServer.readInt();

while ( fileLength > 0 && (current = fromServer.read(buffer, 0, Math.min(4096,fileLength))) > 0)
{
    bOS.write(buffer, 0 , current);
    fileLength -= current;
}