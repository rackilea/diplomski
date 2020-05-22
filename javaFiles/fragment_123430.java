for(long i=1;i<=Math.sqrt(n);i++)
{
    if(n%i==0){
    if(n/i==i)
    al.add(i);
    else {
    al.add(i);
    al.add(n/i);
    }
}
}
Collections.sort(al);