char[] myBuffer = new char[512];
int bytesRead = 0;
BufferedReader in = new BufferedReader(new FileReader("foo.txt"));
while ((bytesRead = in.read(myBuffer,0,512)) != -1)
{
    ...
}