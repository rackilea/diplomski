long length = in.readLong();
long total = 0;
while (total < length && (count = in.read(buffer, 0, length-total > buffer.length ? buffer.length : (int)(length-total))) > 0)
{
    out.write(buffer, 0, count);
    total += count;
}