long remaining = size; // the file size read from the network
while ((count = in.read(buffer, 0, remaining > buffer.length ? buffer.length : (int)remaining)) > 0)
{
    out.write(buffer, 0, count);
    remaining -= count;
}