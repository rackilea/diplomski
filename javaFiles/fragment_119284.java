byte[] buffer = new byte[8192];
int count;
while ((count = in.read(buffer)) > 0)
{
    out.write(buffer, 0, count);
}