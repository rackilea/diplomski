byte buf[1024];
int len;

while((len = read(buf)) >= 0)
{
    /* do something with len bytes of buf */
}