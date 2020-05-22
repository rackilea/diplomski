int count;
byte[] buffer = new byte[8192]; // or more, double or quadruple it

while ((count = in.read(buffer)) > 0)
{
    out.write(buffer, 0, count);
}