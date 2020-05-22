int count=0;
for(int i=0; i < small(a, b).length()-1; i++)
{
        String aSub=a.substring(i,i+2);
        String bSub=b.substring(i,i+2);
        if(aSub.equals(bSub))
        count++;
    }
}
return count;