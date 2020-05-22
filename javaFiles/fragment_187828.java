Object prev = null;
for(Object curr : list)
{
    if( prev != null )
        foo(prev, curr);
    prev = curr;
}