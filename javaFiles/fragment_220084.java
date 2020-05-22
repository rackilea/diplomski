boolean identical = true;
if(m.length() != n.length()) identical = false;
if(identical)
{
 for(int x = 0; x < m.length(); x++)
 {
   if(m[x] != n[x])
   { 
     identical = false;
   }
 }
}
return identical;