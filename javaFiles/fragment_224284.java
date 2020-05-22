tr = s;

do
{   
    tri=tri+Math.pow(tr%10,3);
    tr=tr/10;
}
while(tr!=0);