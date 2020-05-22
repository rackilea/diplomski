int n = 3; //This can change as your array size is not known
String a[] = new String [n];
   a[0]="200,300";
   a[1]="700,500";
   a[2]="900,400"; //And So on


String[] b1 = new String [n];
String[] b2 = new String [n];

for(int i = 0; i<n ; i++)
{
   String [] numbers= a[i].split(",");
   b1[i] = numbers[0];
   b2[i] = numbers[1];
}