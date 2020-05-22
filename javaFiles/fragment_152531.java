byte[] buffer = new byte[8192]; // or much more if you like, but there are diminishing returns
int count;
while ((count = in.read(buffer)) > 0)
{
    out.write(buffer, 0, count);
}