for(int i=0;i<objArray.length;i++)
{
    if (objArray[i].id==inputid)
    {
        out=1;
        break; // found match, break out of loop
    }
    else 
    {
        out=-1;
    }
}
System.out.print(out);