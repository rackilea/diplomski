...
static char buffer[MY_BUFFER_SIZE];
...
ssize_t len;
while((len=gzread(in,buffer,MY_BUFFER_SIZE)) > 0  &&  curr<=index)
    {
    char* p=buffer;
    char* endp=buffer+len;
    while(p < endp)
       {
...