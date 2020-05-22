StringBuilder result = new StringBuilder();
int size = 0;
if(solList!=null && (size=solList.size())>0)
{
   result.append(solList.get(0));
   for ( int i=1;i<size;i++ )
   {
        result.append( ", " ).append(solList.get(i));
    }
 }