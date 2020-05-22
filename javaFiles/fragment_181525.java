int remain = (int) connection.getLength();
byte buf[remain];
int offset = 0, len;

while((len = read(buf, offset, remain)) >= 0)
{
    offset += len;
    remain -= len;
}