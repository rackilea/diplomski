String item;

for(int x = 0; x < 10; x++)
{
    // Linear search.
    if(array[x].equals("Item I am looking for"))
    {
       //you've found the item. Let's stop.
       item = array[x];
       break; 
    }
}