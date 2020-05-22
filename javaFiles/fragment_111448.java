char c =scan.next().charAt(0);
int[][] a;
while(c=='y'||c=='Y')
{

a = new int[ROW][COL]; 
randArray(a, ROW, COL, MIN, MAX);
c =scan.next().charAt(0);
}