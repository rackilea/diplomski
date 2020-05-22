int j = 0;
int count = 0; //Set this variable to the number of times the 'remove' item appears in the list
int[] array2 = new int[array.length - count];
int remove = 6;
for(int i=0; i < array.length; i++)
{
   if(array[i] != remove)
       array2[j++] = array[i];
}