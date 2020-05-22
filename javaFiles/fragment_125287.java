int p=2015;
int foo()
{ ~~~~~~~~~~~~~~~~~~~~~~~>
    int p=2014;          |
    printf("\n %d ",p);  |  This is the local scope 
    return p;            |
} ~~~~~~~~~~~~~~~~~~~~~~~>