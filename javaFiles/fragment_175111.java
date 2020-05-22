char * enc(char * ip)
{
    int r,op;
    int l=strlen(ip);
    r=l-1;
    char curr;
    op=r;
    int curr_count=1,mod_curr_count;
    while(r>=0)
    {
        curr=ip[r];

        while(ip[--r]==curr)
        {

            curr_count++;
        }
        if(curr_count!=1)
        {
            while(curr_count)
            {
            mod_curr_count=curr_count%10;
            ip[op--]=(char)(mod_curr_count+48);
            curr_count/=10;
            }
            ip[op--]=curr;
            curr_count=1;

        }
        else
        {
        ip[op--]=curr;
        }
    }

    ip=ip+op+1;
    return ip;
}