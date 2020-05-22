BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream());
char[] chars = new char[8192];
int count;
while ((count = in.read(chars)) > 0)
{
    buffer.append(chars, 0, count);
    fireDataReceived();
}