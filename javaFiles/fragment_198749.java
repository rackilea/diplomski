newstring="";
for(int i=0;i<dataIn.length();i++)
{
    temp=(int)dataIn.charAt(i);
    if(temp>46&&temp<58)
    {
        newstring=newstring+dataIn.charAt(i);
    }
    if(temp>96&&temp<123)
    {
        newstring=newstring+dataIn.charAt(i);
    }
    if(temp>64&&temp<91)
    {
        newstring=newstring+Character.toLowerCase(dataIn.charAt(i));
    }
}