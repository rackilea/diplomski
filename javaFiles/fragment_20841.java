int len;
while((len=dis.read(buf))!=-1)
{
    ops.write(buf,0,len);
    downloadedSize += len;
}