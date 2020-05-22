byte[] buffer = new byte[4096];
int n;
while ((n = input.read(buffer) != -1)
{
    output.write(buffer, 0, n);
}
output.close();
input.close();