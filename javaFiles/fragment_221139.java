public int replace(String oldData, String newData )
{
     int count = 0;
     StringNode tmp = head;
     while( tmp != null)
     {
       if(tmp.data.equals(oldData)
       {  
         tmp.data = newData;
         count = count + 1;
       }
       tmp = tmp.next;
     }
     return count;

   }