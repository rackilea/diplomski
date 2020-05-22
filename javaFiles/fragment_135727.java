final char[] buffer = new char[256]; // or whatever size you want
int nRead;
while ((nRead = reader.read(buffer)) != -1)
{
    System.out.println(new String(buffer, 0, nRead));
    System.out.flush();
}