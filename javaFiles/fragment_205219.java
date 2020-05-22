int y = 6; // replace with your starting y wherever you are generating it
int[] x = {12, 22, 32, 11, 56}; // replace with your own generated array
Arrays.sort(x); // Remember to import java.util.Arrays; at the top of your file

int matches = 0;
for(int i = 0; i < x.length; i++)
{
    if(x[i] >= 2*y)
    {
       matches++;
       y = x[i];
    }
}
System.out.println(matches); // Print or return depending on your needs here