int point1=0,point2=0,point3=0;
for (int k=0;k<Length;k++)
{
    if (asc[k]>=65 && asc[k]<=90)
    {
        UpperCase[point1]=(char)asc[k];point1++;
        continue;
    }
    else if (asc[k]>=48 && asc[k]<=57)
    {
        Digit[point2]=(char)asc[k];point2++;
        continue;
    }
    else
    {
        Mixed[point3]=(char)asc[k];point3++;
    }

}
System.out.println(UpperCase);
System.out.println(Digit);
System.out.println(Mixed);