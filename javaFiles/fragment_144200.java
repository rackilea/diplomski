int count;
while ((count = in.read(buffer)) > 0)
{
    out.write(buffer, 0, count);
}
out.close();
in.close();