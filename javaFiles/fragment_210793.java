// Check to make sure arrays have same length
if (data.length != s.length) 
   return false;

for (int i=0;i<data.length;i++)
{
    if (data[i]!=s[i])
    {
       return false;
    }
}
return true;