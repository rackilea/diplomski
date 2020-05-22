//get integers m and n from user before this.
long start,end,time;
int[][] a = new int[m][n];
int[][] b = new int[m][n];
int[][] c= new int[m][n];

start = getUserTime();

for(int i = 0;i < m;i++)
{
    for(int j = 0;j < n;j++)
    {
        c[i][j] = a[i][j]+b[i][j];
    }
}
end = getUserTime();

// You could use Math.abs() here to handle the situation where 
// the values could be negative
time = end - start;

/** Get user time in nanoseconds. */
public long getUserTime() {
    return System.nanoTime()
}