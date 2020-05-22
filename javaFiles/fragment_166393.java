for(int j = 1;j < (a.length()+1); j++) 
{ 
    ini[j][1] = gap_score(j-1,0,a,b);
}
for(int i = 1; i < (b.length() + 1);i++)
{
    ini[1][i]= gap_score(0,i-1,a,b);
...