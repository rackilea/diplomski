/*Psudeocode:
ArrayList<Integer> firstCol = //get first column
ArrayList<Integer> secondCol = //get second column
....
ArrayList<Integer> nCol = //get n column
*/
ArrayList<Integer> values = new ArrayList<Integer>();
int currentRow;
for(int i=0;i<n;i++)
{
     currentRow = 0;
     currentRow += firstCol.get(i);
     currentRow += secondCol.get(i);
     //etc, etc...
     values.add(currentRow);
}
//At this point, values contains all the sums of the different rows.
//To calculate the average percent change:
//PR= (((Vpresent - Vpast) / Vpast) x 100) / N
for(int i=0;i<values.size() -1;i++)
{
    System.out.println(((values.get(i+1) - values.get(i)) * 100) / (i+1))
}