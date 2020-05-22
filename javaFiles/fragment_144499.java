int i=0;
while((i<size) && (!visited[i].equals(shop))){
  ++i;
}
if(i>=visited.length){
   //increase the size of your array here.
}
if(i >= size){
   visited[i] = shop;  
   size++;
}


/* get rid of this:
for (int i=0; i<size; i++)
{
    if (visited[i] == null)
    {
        visited[i] = shop;
        break;
    }

    else if (visited[i].equals(shop))
    {
        size -= 1;
    }

    else
    {
        continue;
    }
}
*/