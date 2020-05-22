int[] a = {1,2,3,4,5};
int[] b = {1,2,3,4,5,6};
int[] c = {1,3,7};
int[] d = {2,3,4,8,9,10};

int[] resultArray1 = new int[a.length+b.length+c.length+d.length];
int arrayIndex = 0;

for (int i=0; i< a.length ; i++, arrayIndex++ )
{
    resultArray1[arrayIndex] = a[i];
}
for (int i=0; i< b.length ; i++, arrayIndex++ )
{
    resultArray1[arrayIndex] = b[i];
}   
for (int i=0; i< c.length ; i++, arrayIndex++ )
{
    resultArray1[arrayIndex] = c[i];
}           
for (int i=0; i< d.length ; i++, arrayIndex++ )
{
    resultArray1[arrayIndex] = d[i];
}       

// Sorting Arrays   
System.out.println("Array before Sort"+Arrays.toString(resultArray1));
Arrays.sort(resultArray1);
System.out.println("Array after Sort"+Arrays.toString(resultArray1));


// Removing duplicates
Set<String> set = new HashSet<String>();
for (int i = 0; i < resultArray1.length; i++) {
    set.add(""+resultArray1[i]); // To convert to string
}

String[] uniqueStringArray = set.toArray(new String[set.size()]); ;
int [] uniqueIntArray = new int [uniqueStringArray.length];

// Converting string array to int array
for(int i=0;i<uniqueStringArray.length;i++)
{
    uniqueIntArray[i]= Integer.parseInt(uniqueStringArray[i]);
}
Arrays.sort(uniqueIntArray);
System.out.println("Unique Array after Sort"+Arrays.toString(uniqueIntArray));